package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class Controller02 {

    @RequestMapping(value="/main2/sub1", params = "name")
    public void sub1(WebRequest request){
        // header 정보
        request.getHeader("User-Agent");
        System.out.println("Controller02.sub1");
    }

    // /main2/sub2?name&address
    // ? : query string
    // query string : name1=value1&name2=value2
    @RequestMapping(value = "/main2/sub2", params = {"name","address"})
    public void sub2(WebRequest request){
        System.out.println("Controller02.sub2");
    }

    // /main2/sub3?name=musk
    @RequestMapping(value = "/main2/sub3", params = "name")
    public void sub3(WebRequest request){
        String name = request.getParameter("name");
        System.out.println("name = " + name);
        System.out.println("Controller02.sub2");
    }

    // /main2/sub3?address=seoul
    // /main2/sub3?address=jeju
    @RequestMapping(value="/main2/sub3",params = "address")
    public void sub4(WebRequest request){
        String address = request.getParameter("address");
        System.out.println("address = " + address);
        System.out.println("Controller02.sub3");
    }

    // @RequestParam : 해당 이름의 request parameter를 method parameter 에 binding해줌

    // /main2/sub5?email=gmail
//    @RequestMapping(value="/main2/sub5", params = "email")
//    public void sub5(WebRequest request){
//        String email = request.getParameter("email");
//        System.out.println("email = " + email);
//        System.out.println("Controller02.sub5");
//    }

    @RequestMapping("/main2/sub5")
    public void sub5(@RequestParam("email") String str){
        System.out.println("str = " + str);
    }
}
