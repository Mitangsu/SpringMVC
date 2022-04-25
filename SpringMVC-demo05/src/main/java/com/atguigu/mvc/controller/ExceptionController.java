package com.atguigu.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Su
 * @create 2022-04-11 6:49
 */
@ControllerAdvice
public class ExceptionController {


    //如果出现异常返回页面
    @ExceptionHandler(value ={ArithmeticException.class,NullPointerException.class})
    public String testException(Exception ex, Model model){
        model.addAttribute("ex",ex);
        return "error";
    }

}
