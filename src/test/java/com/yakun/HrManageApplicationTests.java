package com.yakun;

import com.yakun.dao.PartyDao;
import com.yakun.domain.Party;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HrManageApplicationTests {
	@Autowired
	private PartyDao partyDao;

	@Test
	void getPartyByIdTest() {
		Party party = partyDao.getPartyById("10000");
		System.out.println(party);
	}

	@Test
	void getAllPartyTest() {
		List<Party> partyList = partyDao.getAllParty();
		System.out.println(partyList);
	}

}
