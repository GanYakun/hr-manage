package com.yakun.api;

import com.yakun.dto.UserRegisterReqDTO;
import com.yakun.service.UserService;
import com.yakun.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
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
}
