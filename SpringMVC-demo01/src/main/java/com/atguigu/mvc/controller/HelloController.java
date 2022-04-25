package com.atguigu.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Su
 * @create 2022-04-06 12:41
 */
@Controller
public class HelloController {

    //"/"-->/WEB-INF/templates/index.html
    @RequestMapping("/")//请求映射
    public String index(){
        //返回视图名称
        return "index";

    }
    //index是Tomcat默认访问，target一定要写
    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }
}
