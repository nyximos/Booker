package com.booker.backend.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @Column(name = "member_email", nullable = false)
    private String id;

    @Column(name = "member_password", nullable = false)
    private String password;

    @Column(name = "member_name", nullable = false)
    private String name;

    @Column(name = "member_nickname", nullable = false)
    private String nickname;
}
