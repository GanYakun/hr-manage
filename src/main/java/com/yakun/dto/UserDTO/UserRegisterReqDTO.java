package com.yakun.dto.UserDTO;

import lombok.Data;

@Data
public class UserRegisterReqDTO {
    private String username;
    private String password;
    private String repassword;
}
