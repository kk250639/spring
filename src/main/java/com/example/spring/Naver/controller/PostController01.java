package com.example.spring.Naver.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("naver")
public class PostController01 {

    private final PostService postService;

    @PostMapping("/board/write")
    public String sub2(PostDto dto, HttpSession session) {
        Member m = (Member) session.getAttribute("loginUser");
        if (m == null) return "redirect:/login";

        postService.write(dto, m);
        return "redirect:/naver/board/write";
    }

}
