package com.example.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookmarkInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestPath = request.getServletPath();
        if(requestPath.startsWith("/index")){
//            request.setAttribute("ActiveNavbarButton", "main");
        } else if(requestPath.startsWith("/student")){
            request.setAttribute("ActiveNavbarButton", "student");
        } else if(requestPath.startsWith("/group")){
            request.setAttribute("ActiveNavbarButton", "group");
        } else if(requestPath.startsWith("/trainer")){
            request.setAttribute("ActiveNavbarButton", "trainer");
        } else if(requestPath.startsWith("/theme")){
            request.setAttribute("ActiveNavbarButton", "theme");
        } else if(requestPath.startsWith("/program")){
            request.setAttribute("ActiveNavbarButton", "program");
        }  else if(requestPath.startsWith("/about")){
            request.setAttribute("ActiveNavbarButton", "about");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
