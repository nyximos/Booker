package com.booker.backend.service;

import com.booker.backend.config.security.auth.PrincipalDetails;
import com.booker.backend.domain.Member;
import com.booker.backend.domain.MemberRole;
import com.booker.backend.dto.member.JoinDTO;
import com.booker.backend.dto.member.SocialJoinDTO;
import com.booker.backend.dto.response.Message;
import com.booker.backend.dto.response.StatusEnum;
import com.booker.backend.repository.MemberRepository;
import com.booker.backend.service.interfaces.MemberService;
import java.util.Optional;
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
    @Transactional
    public Message join(JoinDTO dto) {

        Member member = Member.builder()
                .username("local_" + dto.getEmail())
                .email(dto.getEmail())
                .password(createEncPassword(dto.getPassword()))
                .name(dto.getName())
                .nickname(dto.getNickname())
                .role(MemberRole.ROLE_USER)
                .build();

        memberRepository.save(member);

        return new Message(StatusEnum.OK, "성공");
    }

    @Override
    @Transactional
    public Message socialJoin(PrincipalDetails principalDetails, SocialJoinDTO socialJoinDTO) {
        Member member = memberRepository.findByUsername(principalDetails.getUsername());
        member.joinSocialAccount(socialJoinDTO.getNickname(),
                createEncPassword(socialJoinDTO.getPassword()));

        return new Message(StatusEnum.OK, "성공");
    }

    @Override
    public Message checkEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isEmpty()) {
            return new Message(StatusEnum.OK, email);
        } else {
            return new Message(StatusEnum.BAD_REQUEST, "이미 등록되어 있는 이메일입니다.");
        }
    }

    private String createEncPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
