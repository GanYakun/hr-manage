package com.yakun.dao;

import com.yakun.domain.UserLogin;
import com.yakun.dto.UserRegisterReqDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserLoginDao {
    @Insert("insert into user_login (user_login_id, current_password, enabled) values (#{username}, #{password}, 'Y')")
    public int insert(UserRegisterReqDTO resDTO);

    @Select("select * from user_login")
    public List<UserLogin> findAll();

    @Select("select * from user_login where user_login_id = #{username}")
    public UserLogin findOne(UserRegisterReqDTO resDTO);
}


