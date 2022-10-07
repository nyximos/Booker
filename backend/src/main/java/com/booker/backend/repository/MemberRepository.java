package com.booker.backend.repository;

import com.booker.backend.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findByEmail(String emailX);

    Member findByUsername(String username);
}
