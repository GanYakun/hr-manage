package com.yakun;

import com.yakun.service.PartyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private PartyService partyService;

    @Test
    public void testFindAllService() {
        partyService.getAllParty();
    }
}
