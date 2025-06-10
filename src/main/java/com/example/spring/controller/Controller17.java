package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main17")
public class Controller17 {

    @GetMapping("sub1")
    public String form1(Model model){
        return "main17/sub1";
    }
    @PostMapping("sub1")
    public String process2(Model model){
        return "main17/sub2";
    }
}
