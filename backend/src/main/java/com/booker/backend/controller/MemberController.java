package com.booker.backend.controller;

import com.booker.backend.config.security.auth.PrincipalDetails;
import com.booker.backend.dto.member.JoinDTO;
import com.booker.backend.dto.TestDTO;
import com.booker.backend.dto.member.SocialJoinDTO;
import com.booker.backend.dto.response.Message;
import com.booker.backend.service.interfaces.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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


    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }


    @GetMapping("/member")
    public String member(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        System.out.println("principalDetails.getName() = " + principalDetails.getName());
        return "member";
    }

    @PostMapping("/join/social")
    public Message socialJoin(@AuthenticationPrincipal PrincipalDetails principalDetails, @RequestBody SocialJoinDTO socialJoinDTO) {
        Message message = memberService.socialJoin(principalDetails, socialJoinDTO);
        return  message;
    }
}
