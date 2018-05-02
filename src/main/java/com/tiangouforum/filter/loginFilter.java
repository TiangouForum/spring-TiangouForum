package com.tiangouforum.filter;

import com.tiangouforum.common.util.Constant;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Du Yihong
 * Decription：
 * Date Create in 2018/2/8
 */
public class loginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String[] notFilter =
                new String[]{"/html", "/js", "/css", "/user/register", "/user/login", "/webjars"};
        String uri = httpServletRequest.getRequestURI();

        boolean doFilter = true;
        for (String s : notFilter) {
            if (uri.contains(s) || uri.equals("/")) {
                doFilter = false;
                break;
            }
        }

        if (doFilter) {
            Object obj = httpServletRequest.getSession().getAttribute(Constant.USER_LOGIN_INFO);
            if (null == obj) {
                boolean isAjaxRequest = isAjaxRequest(httpServletRequest);
                if (isAjaxRequest) {
                    httpServletResponse.setCharacterEncoding("UTF-8");
                    httpServletResponse.sendError(HttpStatus.UNAUTHORIZED.value(), "您已经太长时间没有操作,请刷新页面");
                    return;
                }
                httpServletResponse.sendRedirect("/");
                return;
            } else {
                filterChain.doFilter(httpServletRequest, httpServletResponse);
            }
        } else {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }

    private static boolean isAjaxRequest(HttpServletRequest httpServletRequest) {
        String header = httpServletRequest.getHeader("X-Requested-With");
        return header != null && "XMLHttpRequest".equals(header);
    }
}
