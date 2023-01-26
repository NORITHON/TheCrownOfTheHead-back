package com.noriton.team9.request;

import lombok.Data;

@Data
public class MemberCreationAndLoginRequest {

    private String loginId;
    private String password;
}
