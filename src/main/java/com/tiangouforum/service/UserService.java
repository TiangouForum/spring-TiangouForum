package com.tiangouforum.service;

import com.tiangouforum.dao.FrmuserinfDao;
import com.tiangouforum.domain.Frmuserinf;
import com.tiangouforum.domain.FrmuserinfExample;
import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author Du Yihong
 * Decription：用户信息service层，负责处理用户注册与登陆
 * Date Create in 2018/1/28
 */
@Service("UserService")
public class UserService {
    @Resource(name = "FrmuserinfDao")
    private FrmuserinfDao frmuserinfDao;

    /**
     * 向用户信息表中插入用户新注册信息
     * @param frmuserinf
     */
    @Transactional(rollbackFor = PersistenceException.class)
    public void register(Frmuserinf frmuserinf) {
        frmuserinfDao.insert(frmuserinf);
    }

    /**
     * 验证用户登录时，输入的用户名密码是否正确
     * @param frmuserinf
     * @return
     */
    public boolean varify(Frmuserinf frmuserinf) {
        FrmuserinfExample frmuserinfExample = new FrmuserinfExample();
        frmuserinfExample.createCriteria().
                andUserregnamEqualTo(frmuserinf.getUserregnam()).
                andUserpasswdEqualTo(frmuserinf.getUserpasswd());
        Long count = frmuserinfDao.countByExample(frmuserinfExample);
        if (count == 1) {
            return true;
        }
        return false;
    }
}
