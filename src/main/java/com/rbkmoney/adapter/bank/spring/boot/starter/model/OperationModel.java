package com.rbkmoney.adapter.bank.spring.boot.starter.model;

import com.rbkmoney.damsel.cds.ExpDate;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@Builder
public class OperationModel {

    @ToString.Exclude
    private String pan;
    @ToString.Exclude
    private ExpDate expDate;
    @ToString.Exclude
    private String cvv2;
    private String cardName;

    private Long amount;
    private Short currency;
    private String currencyName;

    private String modifiers;
    private String ip;
    private String email;
    private String country;
    private String city;
    private String region;
    private String address;
    private String phone;

    private String key;
    private String refundId;
    private String descriptions;
    private String callbackUrl;

    private Map<String, String> parameters;

}
