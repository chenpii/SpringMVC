package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenpi
 * @create 2022-09-13 21:52
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    //真实访问地址：localhost:8080/项目名/hello/h1
    @RequestMapping("/h1")
    public String hello(Model model) {

        //封装数据
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg", "Hello,SpringMVCAnnotation");

        //WEB-INF/jsp/hello.jsp
        return "hello"; //会被视图解析器处理
    }
}
