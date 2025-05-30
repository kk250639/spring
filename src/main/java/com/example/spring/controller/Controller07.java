package com.example.spring.controller;

import com.example.spring.dto.MyBean053;
import com.example.spring.dto.MyBean055;
import com.example.spring.dto.MyBean057;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("main7")
public class Controller07 {
    @RequestMapping("sub1")
    public String sub1(Model model) {

        model.addAttribute("aiList",
                List.of("gpt", "gemini", "grok", "deep"));

        return "main7/sub1";
    }

    @RequestMapping("sub2")
    public String sub2(Model model) {
        /*
        |번호|이름|생일|가격|
        |1  |   |   |   |
        .
        .
        |5  |   |   |   |
         */
        model.addAttribute("myList", List.of(
                new MyBean057("lee", "01-01", 5000),
                new MyBean057("kim", "02-02", 4000),
                new MyBean057("son", "03-03", 6000),
                new MyBean057("park", "04-04", 3000),
                new MyBean057("choi", "05-05", 7000)));
        return "main7/sub2";
    }

    @RequestMapping("sub3")
    public String sub3(Model model) {

        model.addAttribute("myList", List.of("java", "spring", "react", "gpt", "grok"));

        return "main7/sub3";
    }

    @RequestMapping("sub4")
    public String sub4(Model model) {
        model.addAttribute("item", new MyBean057("trump", "09-09", 1000));
        model.addAttribute("person", new MyBean055(98, List.of("tesla", "apple"), List.of("seoul", "jeju")));
        return "main7/sub4";
    }

    @RequestMapping("sub5")
    public String sub5(Model model) {

        model.addAttribute("person", new MyBean055(98, List.of("tesla", "apple"), List.of("seoul", "jeju")));

        return "main7/sub5";
    }

    @RequestMapping("sub6")
    public String sub6(Model model) {
        model.addAttribute("person",
                new MyBean055(98, List.of("tesla", "apple"), List.of("seoul", "jeju")));

        return "main7/sub6";
    }

    @RequestMapping("sub7")
    public String sub7(Model model) {
        model.addAttribute("person",
                new MyBean055(98, List.of("tesla", "apple"), List.of("seoul", "jeju")));

        return "main7/sub7";
    }

    @RequestMapping("sub8")
    public String sub8(Model model) {
        model.addAttribute("person",
                new MyBean055(98, List.of("tesla", "apple"), List.of("seoul", "jeju")));

        return "main7/sub7";
    }

    @RequestMapping("sub9")
    public String sub9(Model model) {
        model.addAttribute("name", "son");
        model.addAttribute("married", false);
        model.addAttribute("working", true);
        model.addAttribute("age", 55);
        model.addAttribute("city", null);

        /*
        |번호|무게|이름|결혼|
        .
        .
        |10 |33.3|musk| |
         */

        model.addAttribute("students",
                List.of(new MyBean053(19,33.3,"trump",true),
                        new MyBean053(20, 44.4, "donald",false),
                        new MyBean053(30,55.5,"musk",true),
                        new MyBean053(40,66.6, "elvis", false),
                        new MyBean053(50,77.7,"elon", true)
                ));

        return "main7/sub9";
    }
//    @RequestMapping("sub10")
//    public String sub10(Model model) {}

}
