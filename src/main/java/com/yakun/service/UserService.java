package com.yakun.service;

import com.yakun.dto.userdto.UserLoginReqDTO;
import com.yakun.dto.userdto.UserRegisterReqDTO;
import com.yakun.util.JsonResult;

public interface UserService {
    JsonResult saveUser(UserRegisterReqDTO reqDto);

    JsonResult loginService (UserLoginReqDTO reqDTO);
}
