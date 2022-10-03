package com.booker.backend.config.security.oauth;

import com.booker.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest); // google의 회원 프로필 조회

        System.out.println("userRequest = " + userRequest.getClientRegistration());
        System.out.println("userRequest = " + userRequest.getAccessToken());
        System.out.println("userRequest = " + userRequest.getClientRegistration().getRegistrationId());
        System.out.println(" 안녕 ");

        // token을 통해 응답받은 회원정보
        System.out.println("oAuth2User : " + oAuth2User);

        return super.loadUser(userRequest);
    }
}
