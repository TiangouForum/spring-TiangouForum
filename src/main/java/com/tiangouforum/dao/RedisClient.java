package com.tiangouforum.dao;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ff on 16/04/2018.
 */
public class RedisClient {
    private RedisConfiguration configuration = new RedisConfiguration();

    private JedisPool jedisPool;

    private JedisCluster jedisCluster;

    public RedisClient() {
        this.jedisPool = getJedisPool();
        this.jedisCluster = getJedisCluster();
    }

    private JedisPool getJedisPool(){
        String[] redisAddressList = configuration.getAddressList().split(",");
        if (redisAddressList.length > 1)
            return null;
        String[] hostAndPort = redisAddressList[0].split(":");
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMinIdle(config.getMaxIdle());
        config.setMaxIdle(config.getMaxIdle());
        config.setMaxTotal(config.getMaxTotal());
        config.setMaxWaitMillis(config.getMaxWaitMillis());
        return new JedisPool(config, hostAndPort[0], Integer.parseInt(hostAndPort[1]), Protocol.DEFAULT_TIMEOUT);
    }

    private JedisCluster getJedisCluster(){
        String[] redisAddressList = configuration.getAddressList().split(",");
        if (redisAddressList.length == 1)
            return null;
        Set<HostAndPort> clusterNodes = new HashSet<>();
        for (String node : redisAddressList) {
            String[] ipPort = node.split(":");
            clusterNodes.add(new HostAndPort(ipPort[0], Integer.parseInt(ipPort[1])));
        }
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMinIdle(config.getMaxIdle());
        config.setMaxIdle(config.getMaxIdle());
        config.setMaxTotal(config.getMaxTotal());
        config.setMaxWaitMillis(config.getMaxWaitMillis());
        return new JedisCluster(clusterNodes, Protocol.DEFAULT_TIMEOUT, config);
    }

    public JedisCommands getJedisCommands(){
        if (this.jedisCluster != null) {
            return this.jedisCluster;
        }
         return this.jedisPool.getResource();
    }

    public static  void shutdownJedisCliGracefully(JedisCommands commands){
        //Jedis需要关闭，以基类传入，强转后关闭
        if (commands != null && commands instanceof Jedis) {
            Jedis jedis = (Jedis) commands;
            jedis.close();
        }
    }

}
