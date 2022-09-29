package com.booker.backend.service;

import com.booker.backend.domain.Member;
import com.booker.backend.domain.MemberRole;
import com.booker.backend.dto.member.JoinDTO;
import com.booker.backend.dto.response.Message;
import com.booker.backend.dto.response.StatusEnum;
import com.booker.backend.repository.MemberRepository;
import com.booker.backend.service.interfaces.MemberService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Message join(JoinDTO dto) {

        Member member = Member.builder()
                .email(dto.getUsername())
                .password(createEncPassword(dto.getPassword()))
                .role(MemberRole.ROLE_USER)
                .build();

        memberRepository.save(member);

        return new Message(StatusEnum.OK, "성공");
    }

    private String createEncPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
