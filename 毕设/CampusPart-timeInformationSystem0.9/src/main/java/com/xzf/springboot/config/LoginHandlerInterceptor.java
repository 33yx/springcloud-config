package com.xzf.springboot.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      Object loginUser=  request.getSession().getAttribute("loginUser");

      System.out.println("登陆人："+loginUser);

        if (loginUser==null) {//没有登陆
            request.setAttribute("msg", "没有权限，请先登陆");
            response.sendRedirect("/login");
            return false;
        }else {
            StringBuffer url = request.getRequestURL();

            return true;
        }

    }


}
