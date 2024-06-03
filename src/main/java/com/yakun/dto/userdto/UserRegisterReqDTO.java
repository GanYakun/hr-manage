package com.yakun.dto.userdto;

import lombok.Data;

@Data
public class UserRegisterReqDTO {
    private String username;
    private String password;
    private String repassword;
}
