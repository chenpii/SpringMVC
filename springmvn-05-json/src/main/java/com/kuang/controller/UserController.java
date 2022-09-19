package com.kuang.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kuang.pojo.User;
import com.kuang.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author chenpi
 * @create 2022-09-18 22:29
 */
// @Controller
@RestController //类下面的所有方法都不走视图解析器
public class UserController {

    //produces:指定响应体返回类型和编码
    @RequestMapping(value = "/j1", produces = "application/json;charset=utf-8")
    // @ResponseBody //不会走视图解析器，会直接返回一个字符串
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

    @RequestMapping(value = "j2", produces = "application/json;charset=utf-8")
    public String json2() throws JsonProcessingException {
        ObjectMapper map = new ObjectMapper();

        List<User> users = new ArrayList<>();
        users.add(new User("张三1号", 3, "男"));
        users.add(new User("张三2号", 3, "男"));
        users.add(new User("张三3号", 3, "男"));
        users.add(new User("张三4号", 3, "男"));

        String s = map.writeValueAsString(users);
        return s;
    }

    @RequestMapping(value = "j3", produces = "application/json;charset=utf-8")
    public String json3() throws JsonProcessingException {
        ObjectMapper map = new ObjectMapper();
        //不使用时间戳的方式
        map.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定日期格式
        map.setDateFormat(sdf);

        Date date = new Date();
        String s = map.writeValueAsString(date);
        return s;
    }

    @RequestMapping(value = "j4", produces = "application/json;charset=utf-8")
    public String json4() {
        Date date = new Date();
        String s = JsonUtils.getJson(date);
        return s;
    }
}
