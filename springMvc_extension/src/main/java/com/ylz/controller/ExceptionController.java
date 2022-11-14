package com.ylz.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 杨霖志
 * @date 2022/9/22
 *
 *
 *
 * @ControllerAdvice 将当前类表示为异常处理的组件
 * 注解异常处理
 */

@ControllerAdvice
public class ExceptionController {
   @ExceptionHandler(ArithmeticException.class)
   public String handleArithmeticException(Throwable ex,Model mav) {
      mav.addAttribute("ex",ex);
      return "error";
   }
}
