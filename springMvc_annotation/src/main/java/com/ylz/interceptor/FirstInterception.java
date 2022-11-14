package com.ylz.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 杨霖志
 * @date 2022/9/22
 */
@Component
public class FirstInterception implements HandlerInterceptor {
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      System.out.println("拦截器生效了");
      return true;
   }

   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

   }

   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

   }
}
