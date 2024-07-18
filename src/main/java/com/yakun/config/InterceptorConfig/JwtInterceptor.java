package com.yakun.config.InterceptorConfig;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.yakun.api.UserLoginController;
import com.yakun.constent.Constants;
import com.yakun.domain.UserLogin;
import com.yakun.exception.ServiceException;
import com.yakun.service.UserService;
import com.yakun.util.JsonResult;
import com.yakun.util.MessageUtil.CommonMessageCode;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Component
public class JwtInterceptor extends InterceptorRegistry implements HandlerInterceptor {
    @Autowired
    private UserService userService;


    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object object) throws Exception{

        //获取token
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        // 执行认证
        if (StringUtils.isBlank(token)) {
            throw new ServiceException(Integer.valueOf(CommonMessageCode.NO_TOKEN.getCode()),
                    CommonMessageCode.NO_TOKEN.getMessage());
        }

        //获取token的userid
        String userId;
        try {
            //解密获取
            userId = JWT.decode(token).getAudience().get(0); //得到token中的userid载荷
        } catch (JWTDecodeException j) {
            throw new ServiceException(Integer.valueOf(CommonMessageCode.TOKEN_FAILED.getCode()),
                    CommonMessageCode.TOKEN_FAILED.getMessage());
        }

        //根据userid查询数据库
        UserLogin user = userService.getById(userId);

        if(user == null){
            throw new ServiceException(Integer.valueOf(CommonMessageCode.TOKEN_FAILED.getCode()),
                    CommonMessageCode.TOKEN_FAILED.getMessage());
        }
        // 用户密码加签验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getCurrentPassword())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new ServiceException(Integer.valueOf(CommonMessageCode.TOKEN_FAILED.getCode()),
                    CommonMessageCode.TOKEN_FAILED.getMessage());
        }

        return true;
    }
}
