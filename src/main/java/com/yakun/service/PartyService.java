package com.yakun.service;

import com.yakun.dao.PartyDao;
import com.yakun.domain.Party;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PartyService {
    Party getById(String partyId);
    List<Party> getAllParty();
}
