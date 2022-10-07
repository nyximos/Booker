package com.booker.backend.config.security.oauth;

import com.booker.backend.config.security.auth.PrincipalDetails;
import com.booker.backend.domain.Member;
import com.booker.backend.domain.MemberRole;
import com.booker.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest); // google의 회원 프로필 조회

        System.out.println("userRequest = " + userRequest.getClientRegistration());

        // token을 통해 응답받은 회원정보
        System.out.println("oAuth2User : " + oAuth2User);

        String provider = userRequest.getClientRegistration().getClientId();
        String providerId = oAuth2User.getAttribute("sub");
        String username = provider + "_" + providerId;
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        MemberRole role = MemberRole.ROLE_USER;

        Member memberEntity = memberRepository.findByUsername(username);

        if (memberEntity == null) {
            memberEntity = Member.builder()
                    .username(username)
                    .email(email)
                    .name(name)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            memberRepository.save(memberEntity);
        }

        return new PrincipalDetails(memberEntity, oAuth2User.getAttributes());
    }
}
