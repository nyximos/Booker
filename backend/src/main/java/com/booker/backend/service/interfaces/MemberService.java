package com.booker.backend.service.interfaces;

import com.booker.backend.config.security.auth.PrincipalDetails;
import com.booker.backend.dto.member.JoinDTO;
import com.booker.backend.dto.member.SocialJoinDTO;
import com.booker.backend.dto.response.Message;

public interface MemberService {

    Message join(JoinDTO dto);

    Message socialJoin(PrincipalDetails principalDetails, SocialJoinDTO socialJoinDTO);
}
