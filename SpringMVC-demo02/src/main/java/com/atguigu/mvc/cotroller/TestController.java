package com.atguigu.mvc.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Su
 * @create 2022-04-06 14:31
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/param")
    public String param(){
        return "test_param";
    }

}
