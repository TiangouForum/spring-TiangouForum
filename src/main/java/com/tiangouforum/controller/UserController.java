package com.tiangouforum.controller;

import com.tiangouforum.domain.Frmuserinf;
import com.tiangouforum.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Du Yihong
 * Decription：用户信息controller层，负责用户的注册与登陆
 * Date Create in 2018/1/28
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Resource(name = "UserService")
    private UserService userService;

    @RequestMapping("/register")
    public void register(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Frmuserinf frmuserinf) throws Exception {
        userService.register(frmuserinf);
        httpServletResponse.setHeader("Location", "http://localhost:8080/html/regSuccess.html");
    }
}
