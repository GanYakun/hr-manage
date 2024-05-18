package com.yakun.domain;

import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class Party {
    private String partyId;
    private String partyTypeId;
    private String externalId;
    private String description;
    private String statusId;
    private Timestamp createdDate;
    private String createdByUserLogin;
    private Timestamp lastModifiedDate;

    @Override
    public String toString() {
        return "Party{" +
                "partyId='" + partyId + '\'' +
                ", partyTypeId='" + partyTypeId + '\'' +
                ", externalId='" + externalId + '\'' +
                ", description='" + description + '\'' +
                ", statusId='" + statusId + '\'' +
                ", createdDate=" + createdDate +
                ", createdByUserLogin='" + createdByUserLogin + '\'' +
                ", lastModifiedDate=" + lastModifiedDate +
                ", lastModifiedByUserLogin='" + lastModifiedByUserLogin + '\'' +
                ", partyName='" + partyName + '\'' +
                '}';
    }

    private String lastModifiedByUserLogin;
    private String partyName;

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyTypeId() {
        return partyTypeId;
    }

    public void setPartyTypeId(String partyTypeId) {
        this.partyTypeId = partyTypeId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedByUserLogin() {
        return createdByUserLogin;
    }

    public void setCreatedByUserLogin(String createdByUserLogin) {
        this.createdByUserLogin = createdByUserLogin;
    }

    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedByUserLogin() {
        return lastModifiedByUserLogin;
    }

    public void setLastModifiedByUserLogin(String lastModifiedByUserLogin) {
        this.lastModifiedByUserLogin = lastModifiedByUserLogin;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }
}
