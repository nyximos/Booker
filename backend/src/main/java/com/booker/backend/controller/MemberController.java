package com.booker.backend.controller;

import com.booker.backend.dto.member.JoinDTO;
import com.booker.backend.dto.TestDTO;
import com.booker.backend.dto.response.Message;
import com.booker.backend.service.interfaces.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public Message join(JoinDTO joinDTO) {
        Message message = memberService.join(joinDTO);
        return message;
    }

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
