package com.atguigu.mvc.cotroller;

import com.atguigu.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @author Su
 * @create 2022-04-07 16:13
 */
@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    //形参位置的request表示当前请求
    public String testServletAPI(HttpServletRequest request){
        //第一次创建session后响应报文就会显示jsessionID 然后由Cookie存储到服务器中,下次再来访问 就会再请求报文中显示
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password"+password);

        return "success";
    }

    //MVC请求参数方法
    //形参名和请求参数名一致 可以自动请求参数赋值给形参
    //@RequestParam起别名让它匹配上请求参数保持一致 虽然形参名字不一样但是RequestParam里的数据和请求参数一样
    //@AliasFor起别名字是@RequestParam里的注解 required是否必需 required是true user_name必须传输不然报错400：Required String parameter 'xxx' is not present；
    // 如果是false 没有传输 地址上没有user_name 不报错 默认值null
    //defaultValue不传输请求参数就是地址上没有user_name或者没有写值 空字符串 没有传输 就传输默认值hehe
    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam(value = "user_name",required = false,defaultValue = "hehe") String username,
            String password,
            String[] hobby,
            @RequestHeader(value = "sayHaha",required = true,defaultValue = "haha")String host,
            @CookieValue("JSESSIONID")String JSESSIONID){
        //若请求参数中出现多个同名的请求参数,可以在控制器方法的形参位置设置字符串类型或者字符串数组接收此请求参数
        //若使用字符串类型的形参,最终结果为请求参数的每一个值之间只用逗号进行拼接
        System.out.println("username:"+username+",password:"+password+",hobby:"+ Arrays.toString(hobby));
        System.out.println("host:"+host);
        System.out.println("JSESSIONID:"+JSESSIONID);
        return "success";
    }

    //POJO获取请求参数 根据实体类来获取请求参数
    //获取有乱码如果表单请求方式是get就没有因为tomcat里的配置文件设置默认是UTF-8
    //通过过滤器执行编码格式早于获取请求参数 在web.xml配置 doFilter执行过滤器也可以看参数有没有FilterChain 过滤器链 放行用的
    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        return "success";

    }



}
