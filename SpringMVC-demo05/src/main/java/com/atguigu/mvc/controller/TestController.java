package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Su
 * @create 2022-04-10 17:07
 */
@Controller
public class TestController {
    //拦截器
    @RequestMapping("/**/testInterceptor")
    public String testInterceptor(){
        return "success";
    }


    @RequestMapping("/testExceptionHandler")
    public String testExceptionHandler(){
        System.out.println(1/0);
        return "success";
    }







}








