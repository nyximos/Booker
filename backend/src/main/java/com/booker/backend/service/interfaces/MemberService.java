package com.booker.backend.service.interfaces;

import com.booker.backend.dto.member.JoinDTO;
import com.booker.backend.dto.response.Message;

public interface MemberService {

    Message join(JoinDTO dto);

}
