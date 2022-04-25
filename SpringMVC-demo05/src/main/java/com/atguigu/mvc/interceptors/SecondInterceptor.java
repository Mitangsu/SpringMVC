package com.atguigu.mvc.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器用来拦截控制器方法
     * preHandler在控制器方法执行之前
     * postHandler在控制器方法执行之后
     * render是处理模型渲染识图的方法trigger AfterCompletion在此之后
 * @author Su
 * @create 2022-04-10 17:13
 */
@Component
public class SecondInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("SecondInterceptor-->preHandle");
        //true放行 false拦截
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System. out.println("SecondInterceptor-->postHandle");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("SecondInterceptor-->afterCompletion");
    }
}
