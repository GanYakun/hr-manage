package com.yakun.service.impl;

import com.yakun.dao.UserLoginDao;
import com.yakun.dto.userdto.UserLoginReqDTO;
import com.yakun.dto.userdto.UserRegisterReqDTO;
import com.yakun.service.UserService;
import com.yakun.util.MessageUtil.CommonMessageCode;
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
            //插入用户
            userLoginDao.insert(reqDto);
            //设置注册成功国际化信息
            jsonResult.setMessage(CommonMessageCode.REGISTER_SUCCESS.getMessage());
            //设置状态码
            jsonResult.setCode(CommonMessageCode.REGISTER_SUCCESS.getCode());
        } else {
            //设置重复注册国际化信息
            jsonResult.setMessage(CommonMessageCode.USER_EXISTS.getMessage());
            jsonResult.setCode(CommonMessageCode.USER_EXISTS.getCode());
        }
        return jsonResult;
    }

    @Override
    public JsonResult loginService(UserLoginReqDTO reqDTO) {
        //校验账号是否注册

        //校验密码是否正确

        //返回token
        return null;
    }
}
