package com.yakun.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PartyTypeDao {
    @Select("select description from party_type where party_type_id=#{partyTypeId}")
    String getDescriptionById (String partyTypeId);
}
