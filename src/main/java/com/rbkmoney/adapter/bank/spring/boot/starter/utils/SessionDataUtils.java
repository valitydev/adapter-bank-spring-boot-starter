package com.rbkmoney.adapter.bank.spring.boot.starter.utils;

import com.rbkmoney.damsel.cds.SessionData;

public class SessionDataUtils {

    public static String getCvv2(SessionData sessionData) {
        if (sessionData == null
                || sessionData.getAuthData() == null
                || !sessionData.getAuthData().isSetCardSecurityCode()) {
            return null;
        }
        return sessionData.getAuthData().getCardSecurityCode().getValue();
    }

}
