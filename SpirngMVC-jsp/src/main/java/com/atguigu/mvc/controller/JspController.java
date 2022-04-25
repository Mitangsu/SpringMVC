package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Su
 * @create 2022-04-09 13:24
 */
@Controller
public class JspController {

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

}
