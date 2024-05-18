package com.yakun.dao;

import com.yakun.domain.Party;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface PartyDao {
    @Select("select * from party where party_id = #{partyId}")
    public Party getPartyById(String getPartyById);

    @Select("select * from party")
    public List<Party> getAllParty();
}
