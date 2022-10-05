package com.booker.backend.dto.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinDTO {

    private String email;
    private String password;
    private String name;
    private String nickname;
}
