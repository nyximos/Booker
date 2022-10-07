package com.booker.backend.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Builder
@DynamicUpdate
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_username")
    private String username;

    @Column(name = "member_email")
    private String email;

    @Column(name = "member_password")
    private String password;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_nickname")
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_role")
    private MemberRole role;

    @CreatedDate
    @Column(name = "member_created_Dimetime", updatable = false)
    private LocalDateTime createdDateTime;

    @Column(name = "member_provider")
    private String provider;

    @Column(name = "member_provider_id")
    private String providerId;

    public void joinSocialAccount(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
}
