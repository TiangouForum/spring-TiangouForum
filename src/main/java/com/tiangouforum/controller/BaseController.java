package com.tiangouforum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Du Yihong
 * Decription：统一处理异常信息，设置httpServletRequest，httpServletResponse
 * Date Create in 2018/1/29
 */
public class BaseController {

    @Autowired
    public HttpServletRequest httpServletRequest;

    public HttpServletResponse httpServletResponse;

    @ModelAttribute
    public void setResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    @ExceptionHandler(Exception.class)
    public void HandleExceptions(Exception exception) {
        httpServletResponse.setHeader("Exception", exception.getMessage());
    }

    /**
     * 判断请求是否来自ajax
     * @param httpServletRequest
     * @return
     */
    public static boolean isAjaxRequest(HttpServletRequest httpServletRequest) {
        String header = httpServletRequest.getHeader("X-Requested-With");
        return header != null && "XMLHttpRequest".equals(header);
    }
}
