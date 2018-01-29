package com.tiangouforum.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Du Yihong
 * Decription：统一处理异常信息，进一步TODO：给异常分类，针对不同异常写不同的ExceptionHandler
 * Date Create in 2018/1/29
 */
public class BaseController {
    @ExceptionHandler(Exception.class)
    public void HandleExceptions(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception exception) {
        httpServletResponse.setHeader("Exception", exception.getMessage());
    }
}
