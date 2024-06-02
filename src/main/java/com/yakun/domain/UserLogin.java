package com.yakun.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Repository
public class UserLogin {
    private String userLoginId;
    private String currentPassword;
    private Boolean isSystem;
    private Boolean enabled;
    private Boolean requirePasswordChange;
    private Boolean hasLoggedOut;
    private BigDecimal successiveFailedLogins;
    private String partyId;
    private String disabledBy;
    private Timestamp disabledDateTime;
}
