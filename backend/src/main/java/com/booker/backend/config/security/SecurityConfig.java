package com.booker.backend.config.security;

import com.booker.backend.config.security.auth.AuthFailureHandler;
import com.booker.backend.config.security.auth.AuthSuccessHandler;
import com.booker.backend.config.security.oauth.OAuth2SuccessHandler;
import com.booker.backend.config.security.oauth.PrincipalOauth2UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // IoC bean을 등록
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
// 특정 주소 접근 시 권한 및 인증을 위한 어노테이션 활성화
public class SecurityConfig {

    private final AuthFailureHandler authFailureHandler;
    private final AuthSuccessHandler authSuccessHandler;
    private final PrincipalOauth2UserService principalOauth2UserService;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().disable();
        http.csrf().disable();
        http.authorizeHttpRequests()
                .antMatchers("/admin/**").hasRole("ROLE_ADMIN")
                .antMatchers("/**").permitAll()
                .anyRequest().permitAll();
        http.formLogin()
                .loginPage("/login")
                .failureHandler(authFailureHandler)
                .successHandler(authSuccessHandler);
        http.oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint()
                .userService(principalOauth2UserService)
                .and()
                .successHandler(oAuth2SuccessHandler);
        return http.build();
    }
}
