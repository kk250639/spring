package com.example.spring.controller;

import com.example.spring.dto.MyBean053;
import com.example.spring.dto.MyBean057;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("main6")
public class Controller06 {

    @RequestMapping("sub1")
    public String sub1(Model model) {
        model.addAttribute("cars", Set.of("tesla", "uber", "waymo"));
        model.addAttribute("list", List.of("java", "spring", "css"));
        return "main6/sub1";
    }

    @RequestMapping("sub2")
    public String sub2(Model model) {
        model.addAttribute("aiList", List.of("chatgpt", "claude", "grok", "gemini"));
        model.addAttribute("mySet", Set.of("apple", "orange", "cherry", "banana"));

        return "main6/sub2";
    }

    @RequestMapping("sub3")
    public String sub3(Model model) {
        model.addAttribute("people",
                List.of(new MyBean053(10, 99.5, "donald", true),
                        new MyBean053(20, 88.4, "trump", false),
                        new MyBean053(30, 77.3, "musk", true),
                        new MyBean053(40, 66.2, "ilon", false)));

        return "main6/sub3";
    }
    // 연습 :
    // 모델에 넣은 내용이 table 형식으로 출력되도록 html 코드 작성

    // table>thead>tr>th*3^^tbody>tr*5>th*3>lorem1

    @RequestMapping("sub4")
    public String sub4(Model model) {
        model.addAttribute("myList", List.of(
                new MyBean057("lee", "01-01", 5000),
                new MyBean057("kim", "02-02", 4000),
                new MyBean057("son", "03-03", 6000),
                new MyBean057("park", "04-04", 3000),
                new MyBean057("choi", "05-05", 7000)));

        return "main6/sub4";
    }
}
