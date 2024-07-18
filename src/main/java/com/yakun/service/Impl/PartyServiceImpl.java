package com.yakun.service.Impl;

import com.yakun.dao.PartyDao;
import com.yakun.domain.Party;
import com.yakun.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyServiceImpl implements PartyService {

    @Autowired
    private PartyDao partyDao;

    @Override
    public Party getById(String partyId) {
        return partyDao.getPartyById(partyId);
    }

    @Override
    public List<Party> getAllParty() {
        return partyDao.getAllParty();
    }
}
