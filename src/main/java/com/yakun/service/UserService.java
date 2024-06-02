package com.yakun.service;

import com.yakun.dto.UserRegisterReqDTO;
import com.yakun.util.JsonResult;

public interface UserService {
    JsonResult saveUser(UserRegisterReqDTO reqDto);
}
