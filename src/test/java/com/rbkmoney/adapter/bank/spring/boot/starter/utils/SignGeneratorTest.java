package com.rbkmoney.adapter.bank.spring.boot.starter.utils;

import org.junit.Assert;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

public class SignGeneratorTest {

    public static final String HMAC_SHA_1 = "HmacSHA1";

    @Test
    public void sign() throws NoSuchAlgorithmException {
        String test = "511.483USD677144616IT Books. Qty: 217Books Online Inc.14www.sample.com1512345678901234589999999919pgw@mail.sample.com11--142003010515302116F2B2DD7E603A7ADA33https://www.sample.com/shop/reply";

        String s = SignGenerator.sign(test, "00112233445566778899AABBCCDDEEFF", HMAC_SHA_1);
        Assert.assertEquals("FACC882CA67E109E409E3974DDEDA8AAB13A5E48", s.toUpperCase());
    }
}