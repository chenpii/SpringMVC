package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chenpi
 * @create 2022-09-18 21:47
 */
@Controller
public class EncodingController {
    //过滤器解决乱码
    @PostMapping("/e/t1")
    public String test1(@RequestParam("name") String name, Model model) {
        System.out.println(name);
        model.addAttribute("msg", name);
        return "test";
    }
}
