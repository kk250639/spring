package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("main28")
public class HaveA {


    @GetMapping("sub1")
    public String sub1() {
        System.out.println("Controller28 sub1");
        return null;
    }

    @PostMapping("sub2")
    public String sub2() {
        System.out.println("Controller28 sub2");

        return null;
    }

    @GetMapping("sub3")
    public String sub3() {
        System.out.println("Controller28.sub3");

        return null;
    }

    @PostMapping("sub4")
    public String sub4() {
        System.out.println("Controller28.sub4");

        return null;
    }

    @GetMapping("sub6")
    public String sub6(@RequestParam Map<String, Object> map) {
        Object val1 = map.get("val1");
        Object val2 = map.get("val2");
        Object val3 = map.get("val3");
        Object val4 = map.get("val4");
        Object val5 = map.get("val5");

        System.out.println("val1 = " + val1.getClass().getSimpleName());
        System.out.println("val2 = " + val2.getClass().getSimpleName());
        System.out.println("val3 = " + val3.getClass().getSimpleName());
        System.out.println("val4 = " + val4.getClass().getSimpleName());
        System.out.println("val5 = " + val5); // null

        return null;
    }

}
