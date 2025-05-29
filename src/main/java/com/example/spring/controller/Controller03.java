package com.example.spring.controller;

import com.example.spring.dto.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/main3") // 모든 메소드의 앞 경로 생략
public class Controller03 {

    //
    @RequestMapping("sub1")
    public void sub1() {
        System.out.println("Controller3.sub1");
    }

    @RequestMapping("sub2")
    public void sub2() {
        System.out.println("Controller3.sub2");
    }

    // 연습:
    // /main3/sub3 요청 올 떄 일하는 메소드 작성
    @RequestMapping("sub3")
    public void sub3() {
        System.out.println("Controller3.sub3");
    }

    @RequestMapping("sub4")
    public void sub4(@RequestParam("param1") String param1,
                     @RequestParam("param2") String param2) {
        System.out.println("param1 = " + param1);
        System.out.println("param2 = " + param2);
    }

    @RequestMapping("sub5")
    public void sub5(@RequestParam Map<String, String> params){
        for (Map.Entry<String, String> entry : params.entrySet()) {
            System.out.println(entry.getKey()+" = " + entry.getValue());
        }

    }

    // request parameter를 java beans (Data Transaction Object)으로 받기
    // /main3/sub6?name=donald&address=18
    // /main3/sub3/address=ny
    @RequestMapping("sub6")
    public void sub6(MyBean031 params) {
        System.out.println("params.getName() = " + params.getName());
        System.out.println("params.getAddress(); = " + params.getAddress());
    }

    // 연습
    // main3/sub7?name=musk&company=tesal&home=texas
    // MyBean032 javaBean(dto)를 만들어서 request parameter 받아보기
    @RequestMapping("sub7")
    public void sub7(MyBean032 params) {
        System.out.println("params.getName() = " + params.getName());
        System.out.println("params.getCompany() = " + params.getCompany());
        System.out.println("params.getHome() = " + params.getHome());
        System.out.println("params.getAge() = " + params.getAge());
    }

    // /main3/sub8?nickName=trump&age=55&address=ny&score=98.99
    @RequestMapping("sub8")
    public void sub8(MyBean033 params) {
        System.out.println(params);
    }

    // /main3/sub9?address=seoul&salary=50.5
    @RequestMapping("sub9")
    public void sub9(MyBean035 params) {
        System.out.println(params);
    }

    // 연습:
    // /main3/sub10?age=44&email=gmail&married=true&salary=40.4&name=donald
    // 요청 파라미터 받는 MyBean36 클래스 만들고
    // 메소드 확정
    // request handler method
    @RequestMapping("sub10")
    public void sub10(MyBean036 params) {
        System.out.println(params);
    }

    // /main3/sub11?name=donald&address=ny&spw=1234
    // /main3/sub11?name=donald&address=ny

    // request paremeter와 같은 이름의 메소드를 사용
    @RequestMapping("sub11")
    public void sub11(MyBean037 params) {
        System.out.println(params);
    }

    // /main3/sub12?name=donald&age=66&skill=work&skil=baseball&skill=java&skill=css
    @RequestMapping("sub12")
    public void sub12(MyBean038 params) {

    }


    // 연습
    // /main3/sub13?hobby=cook&hobby=walk&hoby=running&score=3.3&score=4.4&score=5.5
    // dto(MyBean0311)와 request handler method 만들기
    @RequestMapping("sub13")
    public void sub13(MyBean0311 params, Double[] score) {
        System.out.println(params);
        System.out.println(Arrays.toString(score));
    }
}
