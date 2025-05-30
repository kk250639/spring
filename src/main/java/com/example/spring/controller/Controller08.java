package com.example.spring.controller;

import com.example.spring.dto.MyBean057;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("main8")
public class Controller08 {

    @RequestMapping("sub01")
    public String sub01(Model model) {

        model.addAttribute("a");

        return "main8/sub01";
    }
    @RequestMapping("sub2")
    public String sub2(Model model) {

        /*
        가격은 italic 체로 출력
        5000원 이상은 굵은 글씨로
        |이름|생일 |가격
        |lee|01-01|5000
         */


        model.addAttribute("myList", List.of(
                new MyBean057("lee", "01-01", 5000),
                new MyBean057("kim", "02-02", 4000),
                new MyBean057("son", "03-03", 6000),
                new MyBean057("park", "04-04", 3000),
                new MyBean057("choi", "05-05", 7000)));

        return "main8/sub2";
    }@RequestMapping("sub3")
    public String sub03(Model model, HttpSession session) {

        model.addAttribute("myList", List.of());

        return "main8/sub3";
    }@RequestMapping("sub4")
    public String sub04(Model model, String animal) {

        model.addAttribute("animal", animal);

        return "main8/sub4";
    }

    @RequestMapping("sub5")
    public String sub05() {

        return "main8/sub5";
    }

    @RequestMapping("sub6")
    public String sub06() {

        return "main8/sub6";
    }

    @RequestMapping("sub7")
    public String sub07() {

        return "main8/sub7";
    }@RequestMapping("sub8")
    public String sub08() {

        return "main8/sub8";
    }
}
