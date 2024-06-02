package com.yakun;

import com.yakun.dao.UserLoginDao;
import com.yakun.domain.Party;
import com.yakun.domain.UserLogin;
import com.yakun.dto.UserRegisterReqDTO;
import com.yakun.service.PartyService;

import com.yakun.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private PartyService partyService;

    @Autowired
    private Party party;

    @Autowired
    private UserService userService;

    @Autowired
    private UserLoginDao userLoginDao;

    @Test
    public void testFindAllService() {
        partyService.getAllParty();
    }

    @Test
    public void testUserRegisterService() {
        UserRegisterReqDTO userRegisterReqDTO = new UserRegisterReqDTO();
        userRegisterReqDTO.setUsername("GanYakun");
        userRegisterReqDTO.setPassword("abc123");
        userService.saveUser(userRegisterReqDTO);
        List<UserLogin> all = userLoginDao.findAll();
        for (UserLogin userLogin : all) {
            System.out.println(userLogin);
        }
    }
}
