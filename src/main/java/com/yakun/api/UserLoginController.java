package com.yakun.api;

import com.yakun.dto.UserDTO.UserLoginReqDTO;
import com.yakun.dto.UserDTO.UserRegisterReqDTO;
import com.yakun.service.UserService;
import com.yakun.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userLogin")
public class UserLoginController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping("/register")
    public JsonResult register(@RequestBody UserRegisterReqDTO reqDTO) {
        JsonResult jsonResult = userService.saveUser(reqDTO);
        jsonResult.setData("");
        return jsonResult;
    }

    @CrossOrigin
    @RequestMapping("/login")
    public JsonResult login(@RequestBody UserLoginReqDTO reqDTO) {
        JsonResult jsonResult = userService.loginService(reqDTO);
        jsonResult.setData("");
        return jsonResult;
    }
}
