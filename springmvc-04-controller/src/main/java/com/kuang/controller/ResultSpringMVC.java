package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenpi
 * @create 2022-09-18 20:53
 */
@Controller
public class ResultSpringMVC {
    private HttpServletRequest request;

    //直接访问,转发
    @RequestMapping("/rsm/t1")
    public String test1(Model model) {
        model.addAttribute("msg", "ResultSpringMVC_test1");
        return "/WEB-INF/jsp/test.jsp";
    }

    //转发2
    @RequestMapping("/rsm/t2")
    public String test2(Model model) {
        model.addAttribute("msg", "ResultSpringMVC_test2");
        return "forward:/WEB-INF/jsp/test.jsp";
    }

    //重定向
    @RequestMapping("/rsm/t3")
    public String test3(Model model) {
        model.addAttribute("msg", "ResultSpringMVC_test3");
        return "redirect:/index.jsp";
    }
}
