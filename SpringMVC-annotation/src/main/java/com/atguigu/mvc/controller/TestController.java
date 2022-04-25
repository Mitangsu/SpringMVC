package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Su
 * @create 2022-04-11 7:46
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
