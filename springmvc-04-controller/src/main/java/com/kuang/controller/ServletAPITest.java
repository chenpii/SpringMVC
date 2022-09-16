package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ServletAPITest {

    @GetMapping("/servlet/t1")
    public void test1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("Hello,Spring BY servlet API");
    }

    @GetMapping("/servlet/t2")
    //响应重定向
    public void test2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }

    @GetMapping("/servlet/t3")
    //请求转发
    public void test3(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("msg","/servlet/t3");
        request.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request,response);
    }

}
