package com.noriton.team9.request;

import lombok.Data;

@Data
public class UserCreationAndLoginRequest {

    private String loginId;
    private String password;
}
