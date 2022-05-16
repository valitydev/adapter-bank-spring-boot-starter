package dev.vality.adapter.bank.spring.boot.starter.utils;

import dev.vality.adapter.common.utils.CardDataUtils;
import dev.vality.cds.storage.AuthData;
import dev.vality.cds.storage.CardSecurityCode;
import dev.vality.cds.storage.SessionData;
import org.junit.Assert;
import org.junit.Test;

public class SessionDataUtilsTest {

    private static final String CARD_SECURITY_CODE = "adfdfs";

    @Test
    public void getCvv2() {
        SessionData sessionData = new SessionData();
        String cvv2 = CardDataUtils.extractCvv2(sessionData);

        Assert.assertNull(cvv2);

        AuthData authData = new AuthData();
        sessionData.setAuthData(authData);
        cvv2 = CardDataUtils.extractCvv2(sessionData);

        Assert.assertNull(cvv2);

        CardSecurityCode cardSecurityCode = new CardSecurityCode();
        authData.setCardSecurityCode(cardSecurityCode);
        cvv2 = CardDataUtils.extractCvv2(sessionData);

        Assert.assertNull(cvv2);

        cardSecurityCode.setValue(CARD_SECURITY_CODE);

        cvv2 = CardDataUtils.extractCvv2(sessionData);

        Assert.assertEquals(CARD_SECURITY_CODE, cvv2);
    }

}