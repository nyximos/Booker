package com.booker.backend.config.security.auth;

import com.booker.backend.domain.Member;
import com.booker.backend.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public PrincipalDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> member = memberRepository.findByEmail(username);
        if (member == null) {
            return null;
        }
        Member memberEntity = member.orElse(null);

        return new PrincipalDetails(memberEntity);
    }
}
