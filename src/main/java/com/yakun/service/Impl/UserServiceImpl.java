package com.yakun.service.Impl;

import com.yakun.dao.UserLoginDao;
import com.yakun.domain.UserLogin;
import com.yakun.dto.UserDTO.UserLoginReqDTO;
import com.yakun.dto.UserDTO.UserRegisterReqDTO;
import com.yakun.service.UserService;
import com.yakun.util.MessageUtil.CommonMessageCode;
import com.yakun.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserLoginDao userLoginDao;

    @Override
    public JsonResult saveUser(UserRegisterReqDTO reqDto) {
        JsonResult jsonResult = new JsonResult();
        if (Objects.isNull(userLoginDao.findOne(reqDto))) {
            //插入用户
            userLoginDao.insert(reqDto);
            //设置注册成功国际化信息
            jsonResult.setMessageCode(CommonMessageCode.REGISTER_SUCCESS);
        } else {
            //设置重复注册国际化信息
            jsonResult.setMessageCode(CommonMessageCode.USER_EXISTS);
        }
        return jsonResult;
    }

    @Override
    public JsonResult loginService(UserLoginReqDTO reqDTO) {
        JsonResult jsonResult = new JsonResult();
        //校验密码是否正确
        UserLogin userLogin  = userLoginDao.findByUserName(reqDTO.getUsername());
        if (Objects.isNull(userLogin)) {
            jsonResult.setMessageCode(CommonMessageCode.USER_NOT_EXISTS);
        } else {
            if (userLogin.getCurrentPassword().equals(reqDTO.getPassword())) {
                String token = UUID.randomUUID().toString();
                userLoginDao.updateFailedLogins(userLogin.getUserLoginId(), BigDecimal.ZERO);
                jsonResult.setToken(token);
                jsonResult.setMessageCode(CommonMessageCode.LOGIN_SUCCESS);
            } else {
                BigDecimal successiveFailedLogins = userLogin.getSuccessiveFailedLogins();
                userLoginDao.updateFailedLogins(userLogin.getUserLoginId(), successiveFailedLogins.add(BigDecimal.ONE));
                jsonResult.setMessageCode(CommonMessageCode.WRONG_PW);
            }
        }
        return jsonResult;
    }

    @Override
    public UserLogin getById(String userId) {
        return userLoginDao.findByUserLoginId(userId);
    }
}
