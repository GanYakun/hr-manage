package com.yakun.service.impl;

import com.yakun.dao.UserLoginDao;
import com.yakun.dto.UserRegisterReqDTO;
import com.yakun.service.UserService;
import com.yakun.util.CommonMessageCode;
import com.yakun.util.JsonResult;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserLoginDao userLoginDao;

    @Resource
    private JsonResult jsonResult;

    @Override
    public JsonResult saveUser(UserRegisterReqDTO reqDto) {
        if (userLoginDao.findOne(reqDto) == null) {
            userLoginDao.insert(reqDto);
            jsonResult.setMessage(CommonMessageCode.REGISTER_SUCCESS.getMessage());
            jsonResult.setCode(CommonMessageCode.REGISTER_SUCCESS.getCode());
        } else {
            jsonResult.setMessage(CommonMessageCode.USER_EXISTS.getMessage());
            jsonResult.setCode(CommonMessageCode.USER_EXISTS.getCode());
        }
        return jsonResult;
    }
}
