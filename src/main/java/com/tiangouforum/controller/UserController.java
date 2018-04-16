package com.tiangouforum.controller;

import com.tiangouforum.common.util.Constant;
import com.tiangouforum.domain.Frmuserinf;
import com.tiangouforum.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    public ModelAndView login(Frmuserinf frmuserinf) throws IOException {
        if (userService.varify(frmuserinf)) {
            httpServletRequest.getSession().setAttribute(Constant.USER_LOGIN_INFO, frmuserinf);
            httpServletResponse.setHeader("login", "success");
            Map<String, String> modelMap = new HashMap<String, String>();
            modelMap.put("username", frmuserinf.getUserregnam());
            return new ModelAndView("/home/tiangou_home_index", modelMap);
        } else {
            Map<String, String> modelMap = new HashMap<String, String>();
            modelMap.put("msg", "账号或密码错误，请重新输入！");
            return new ModelAndView("forward:/jsp/login/tiangou_login_main.jsp", modelMap);
        }
    }
}
