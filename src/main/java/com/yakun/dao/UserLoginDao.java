package com.yakun.dao;

import com.yakun.domain.UserLogin;
import com.yakun.dto.UserDTO.UserRegisterReqDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface UserLoginDao {
    @Insert("insert into user_login (user_login_id, current_password, enabled, successive_failed_logins) values (#{username}, #{password}, 'Y', 0)")
    public int insert(UserRegisterReqDTO resDTO);

    @Select("select * from user_login")
    public List<UserLogin> findAll();

    @Select("select * from user_login where user_login_id = #{userLoginId}")
    public UserLogin findByUserLoginId(String userLoginId);

    @Select("select * from user_login where user_login_id = #{username}")
    public UserLogin findOne(UserRegisterReqDTO resDTO);

    @Select("select * from user_login where user_login_id = #{username}")
    public UserLogin findByUserName(String username);

    @Update("update user_login set successive_failed_logins = #{successiveFailedLogins} where user_login_id = #{username}")
    public int updateFailedLogins (String username, BigDecimal successiveFailedLogins);
}


