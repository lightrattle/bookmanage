package com.bookmanage.utils;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


/**
 *新建拦截器
 * 自定义拦截器
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        // 拦截处理代码

        //静态资源不被拦截器拦截
        String uri = request.getRequestURI();
        if (uri.endsWith("js")||uri.endsWith("css")||uri.endsWith("jpg")
                ||uri.endsWith("svg")||uri.endsWith("jpg")||uri.endsWith("png")){
            return true ;
        }
        HttpSession session = request.getSession();
        // 获取用户信息，如果没有用户信息直接返回提示信息
        Object userInfo = session.getAttribute("loginUser");
        if (userInfo == null) {
            request.setAttribute("msg","请登录！");
            request.getRequestDispatcher("/login.html").forward(request, response);
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}