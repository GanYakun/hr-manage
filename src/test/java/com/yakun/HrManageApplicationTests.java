package com.yakun;

import com.yakun.dao.PartyDao;
import com.yakun.dao.PartyTypeDao;
import com.yakun.domain.Party;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HrManageApplicationTests {
	@Autowired
	private PartyDao partyDao;
	@Autowired
	private PartyTypeDao partyTypeDao;

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

	@Test
	void getDescriptionByIdTest() {
		String person = partyTypeDao.getDescriptionById("PERSON");
		String partyGroup = partyTypeDao.getDescriptionById("PARTY_GROUP");
		System.out.println("Description is: "+person+ "/" + partyGroup);
	}

}
