package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Controller
@RequestMapping("/main99")   // @RequestMapping : path에 해당하는 메소드 호출
public class Controller99 {     // 모든 메소드의 경로 앞 부분에 적용

    // ? : query string ex) name1=value1&name2=value2
    // @Requestparam : 해당 이름의 request parameter를 method parameter 에 binding 해줌
    // WebRequest : 요청 정보가 담기는 객체
    @RequestMapping(value={"/sub1","/sub2"}, params = "name")
    public void sub1(WebRequest request, @RequestParam("star") String star) {
        String s = request.getHeader("User-Agent");
        String t = request.getHeader("Accept");
        System.out.println(s);
        System.out.println(t);

        System.out.println("Controller99.sub1");
    }

    @RequestMapping("/sub3")
    public void sub3(@RequestParam String star,     // request parameter의 이름이
                     Integer year) {  // method parameter와 같으면 value 속성 생략 해도됨
        System.out.println("star = " + star);       // @Requestparam도 생략가능
        System.out.println("year = " + year);
    }

    // required = false : 값이 없어도 유지 가능, 생략가능
    // defaultValue를 통해 기본값 지정도 가능
    @RequestMapping("/sub4")
    public void sub4(@RequestParam(required = false, defaultValue = "") String star,
                     @RequestParam(defaultValue = "0") Integer year) {
        System.out.println("star = " + star);
        System.out.println("year = " + year);
    }

    @RequestMapping("/sub5")
    public void sub5(@RequestParam Map<String, Object> params) {
        for (var entry : params.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }

}
