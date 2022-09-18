package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenpi
 * @create 2022-09-18 21:10
 */
@Controller
public class ResultSpringMVC2 {

    //请求转发
    @RequestMapping("/rsm2/t1")
    public String test1(Model model) {
        model.addAttribute("msg", "ResultSpringMVC2_test1");
        return "test";
    }

    //响应重定向
    @RequestMapping("/rsm2/t2")
    public String test2() {
        // return "redirect:/index.jsp";
        return "redirect:hello.do"; //hello.do为另一个请求
    }

    @RequestMapping("/rsm2/hello.do")
    public String test3(Model model) {
        model.addAttribute("msg", "hello");
        return "test";
    }
}
