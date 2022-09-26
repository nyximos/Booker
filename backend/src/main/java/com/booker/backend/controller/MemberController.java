package com.booker.backend.controller;

import com.booker.backend.dto.TestDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @PostMapping("/test")
    public String test(@RequestBody TestDTO testDTO) {
        System.out.println("title = " + testDTO.getTitle());
        System.out.println("content = " + testDTO.getContent());
        return "Hello World";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/admin")
    public String addmin() {
        return "admin";
    }
}
