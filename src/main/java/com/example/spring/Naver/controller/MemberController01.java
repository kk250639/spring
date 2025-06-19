package com.example.spring.Naver.controller;

import com.example.spring.Naver.dto.MemberEntityDto;
import com.example.spring.Naver.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("naver")
public class MemberController01 {

    private MemberService memberService;

    @PostMapping("/register")
    public String sub1(MemberEntityDto dto) {
        memberService.save(dto);
        return "naver/register";
    }

}
