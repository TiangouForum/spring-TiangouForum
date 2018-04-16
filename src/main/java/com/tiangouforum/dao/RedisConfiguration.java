package com.tiangouforum.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ff on 16/04/2018.
 */
public class RedisConfiguration {
    private int minIdle;

    private int maxIdle;

    private int maxTotal;

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    private long maxWaitMillis;

    private String addressList;

    public RedisConfiguration(){
        minIdle = 0;
        maxIdle = 8;
        maxTotal = 10;
        maxWaitMillis = 2000;
        addressList = "localhost:6379,localhost:6380";
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public long getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public String getAddressList() {
        return addressList;
    }

    public void setAddressList(String addressList) {
        this.addressList = addressList;
    }
}
