package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author chenpi
 * @create 2022-09-18 21:19
 */
@Controller
@RequestMapping("/user")
public class UserController {

    //localhost:8080/user/t1?name=xxx
    @RequestMapping("t1")
    public String test1(String name, Model model) {
        //1.接收前端参数
        System.out.println("接收到的前端参数为：" + name);
        //2.将返回的结果传递给前端
        model.addAttribute("msg", name);
        //3.视图跳转
        return "test";
    }

    //localhost:8080/user/t2?username=xxx
    @RequestMapping("t2")
    public String test2(@RequestParam("username") String name, Model model) {
        //1.接收前端参数
        System.out.println("接收到的前端参数为：" + name);
        //2.将返回的结果传递给前端
        model.addAttribute("msg", name);
        //3.视图跳转
        return "test";
    }

    //前端传递的是一个对象：id name  age
    //http://localhost:8080/user/t3?id=1&name=qinjiang&age=18
    /*
    1.接收前端传递的参数，判断参数的名字，假设名字直接在方法上，可以直接使用
    2.假设传递的是一个对象，匹配对象中的字段名；如果字段匹配则OK；否则匹配不到
     */
    @RequestMapping("/t3")
    public String test3(User user) {
        System.out.println(user);
        return "test";
    }

}
