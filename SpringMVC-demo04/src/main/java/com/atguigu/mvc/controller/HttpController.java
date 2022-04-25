package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求头 请求行 请求体
 * @author Su
 * @create 2022-04-10 6:50
 */
@Controller
public class HttpController {


    //@RequestBody
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println("requestBody"+requestBody); //requestBody username=addmin&password=123
        return "success";
    }

    //RequestEntity类型 整个请求报文的信息
    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        System.out.println("请求头:"+requestEntity.getHeaders());
        System.out.println("请求体:"+requestEntity.getBody());
        return "success";
    }

    //页面显示内容
    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().write("hello,response");
    }

    //如果加上@ResponseBody return的内容就会显示到页面 如果不加的话就是被thymeleaf所渲染变成跳转网页
    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success123";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        return new User(1001,"张三","123456",23,"男");
    }

    @RequestMapping("testAxios")
    @ResponseBody
    public String testAxios(String username,String password){
        System.out.println(username+","+password);
        return "hello,axios";
    }

}








