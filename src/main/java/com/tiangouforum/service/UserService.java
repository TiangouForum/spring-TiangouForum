package com.tiangouforum.service;

import com.tiangouforum.dao.FrmuserinfDao;
import com.tiangouforum.domain.Frmuserinf;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Du Yihong
 * Decription：用户信息service层，负责处理用户注册与登陆
 * Date Create in 2018/1/28
 */
@Service("UserService")
public class UserService {
    @Resource(name="FrmuserinfDao")
    private FrmuserinfDao frmuserinfDao;

    public void register(Frmuserinf frmuserinf) throws Exception{
        try {
            frmuserinfDao.insert(frmuserinf);
        }catch (Exception e) { //TODO 为框架增加异常处理功能
            throw e; //runtimeException，可以不必catch的
        }

    }

}
