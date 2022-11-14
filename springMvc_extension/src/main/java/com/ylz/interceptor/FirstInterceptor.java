package com.ylz.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 杨霖志
 * @date 2022/9/22
 */
public class FirstInterceptor implements HandlerInterceptor {
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      //控制器方法执行前执行
      System.out.println("控制器方法前执行");
      return true;
   }

   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
      //控制器方法执行后执行
      System.out.println("控制器方法执行完毕");
   }

   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
      //视图渲染完成之后执行
      System.out.println("视图渲染完毕");
   }
}
