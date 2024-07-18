package com.yakun.service;

import com.yakun.domain.UserLogin;
import com.yakun.dto.UserDTO.UserLoginReqDTO;
import com.yakun.dto.UserDTO.UserRegisterReqDTO;
import com.yakun.util.JsonResult;

public interface UserService {
    JsonResult saveUser(UserRegisterReqDTO reqDto);

    JsonResult loginService (UserLoginReqDTO reqDTO);

    UserLogin getById (String userId);
}
