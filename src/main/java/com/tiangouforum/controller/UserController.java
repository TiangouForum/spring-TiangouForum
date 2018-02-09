package com.tiangouforum.controller;

import com.tiangouforum.common.util.Constant;
import com.tiangouforum.domain.Frmuserinf;
import com.tiangouforum.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;

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
    public void register(Frmuserinf frmuserinf) throws Exception {
        userService.register(frmuserinf);
        httpServletResponse.setHeader("Location", "http://localhost:8080/html/regSuccess.html");
    }

    @RequestMapping("/login")
    public void login(Frmuserinf frmuserinf) throws IOException {
        if (userService.varify(frmuserinf)) {
            httpServletRequest.getSession().setAttribute(Constant.USER_LOGIN_INFO, frmuserinf);
        } else {
            if (isAjaxRequest(httpServletRequest)) {
                httpServletResponse.setCharacterEncoding("UTF-8");
                httpServletResponse.sendError(HttpStatus.UNAUTHORIZED.value(), "用户名或密码错误，请重新登陆！");
                return;
            }
            httpServletResponse.sendRedirect("/");
            return;
        }
    }
}
