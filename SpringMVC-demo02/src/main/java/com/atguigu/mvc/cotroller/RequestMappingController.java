package com.atguigu.mvc.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.security.ec.SunEC;

/**
 * get:查询用户信息
 * post:新增用户信息
 * put:修改用户信息
 * delete:删除用户信息
 * 但是目前浏览器只支持get和post，若在form表单提交时，为method设置了其他请求方式的字符串（put或delete），则按照默认的请求方式get处理
 * 若要发送put和delete请求，则需要通过spring提供的过滤器HiddenHttpMethodFilter，在RESTful部分会讲到
 * @author Su
 * @create 2022-04-06 18:56
 */
@Controller
//@RequestMapping("/hello") 可以作为一整个模块进行相同value的赋值例如 /users/list /order/list
public class RequestMappingController {
      //只能有一个RequestMapping映射值value值
//    @RequestMapping("/")
//    public String index(){
//        return "target";
//    }

    //post比较安全
    @RequestMapping(
                value = {"/testRequestMapping","/test"},
                // Request method 'POST' not supported
                method = {RequestMethod.GET,RequestMethod.POST}
    )
    public String success(){
        return "success";
    }


    @GetMapping("/testGetMapping")
    public String testGetMapping(){
        return "success";
    }

    //HTTP Status 405 - Request method 'GET' not supported
    @RequestMapping(value = "/testPut",method = RequestMethod.PUT)
    public String testPut(){
        return "success";
    }

    //如果没有携带username 报错：
    //HTTP Status 400 - Parameter conditions "username" not met for actual request parameters:
    @RequestMapping(
            //如果value和请求头不匹配报404 请求方式不对报405 传输不匹配报400
            value = "/testParamsAndHeaders",
            params = {"username","password=123456"},
            headers = {"Host=localhost:8081"}
    )
    public String testParamsAndHeaders(){
        return "success";
    }

    //ant风格的路径
    //?:可以表示任意字符
    //*:表示任意的0个或多个字符
    //**：表示任意的一层或多层目录
//  一个字符好使 不写,俩字符,?,/不好使
//  @RequestMapping("/a?a/testAnt")
//  @RequestMapping("/a*a/testAnt")
    @RequestMapping("/a**a/testAnt")
    public String test(){
        return "success";
    }


    @RequestMapping("/shopping")
    public String test1(){
        return "success";
    }

    //{}占位符
    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id")Integer id,@PathVariable("username")String name){
        System.out.println("id:"+id+"username:"+name);
        return "success";
    }


}













