package com.example.demo.util;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object object=request.getSession().getAttribute("user");
        if (object==null){
            request.setAttribute("message","没有权限，请先登录");
            response.sendRedirect("/index");
            //request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
}
