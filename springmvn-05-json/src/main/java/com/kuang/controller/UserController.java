package com.kuang.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author chenpi
 * @create 2022-09-18 22:29
 */
@Controller
public class UserController {

    //produces:指定响应体返回类型和编码
    @RequestMapping(value = "/j1",produces = "application/json;charset=utf-8")
    @ResponseBody //不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {

        //jackson ObjectMapper
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User("张三1号", 3, "男");

        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(user);

        return str;
    }
}
