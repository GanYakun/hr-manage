package com.yakun.domain;

public class PartyType {
    private String partyTypeId;
    private String description;
    private String parentTypeId;

    @Override
    public String toString() {
        return "PartyType{" +
                "partyTypeId='" + partyTypeId + '\'' +
                ", description='" + description + '\'' +
                ", parentTypeId='" + parentTypeId + '\'' +
                '}';
    }

    public String getPartyTypeId() {
        return partyTypeId;
    }

    public void setPartyTypeId(String partyTypeId) {
        this.partyTypeId = partyTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParentTypeId() {
        return parentTypeId;
    }

    public void setParentTypeId(String parentTypeId) {
        this.parentTypeId = parentTypeId;
    }
}
