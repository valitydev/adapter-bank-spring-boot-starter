package com.rbkmoney.adapter.bank.spring.boot.starter.model;

import com.rbkmoney.adapter.bank.spring.boot.starter.constants.TargetStatus;
import com.rbkmoney.damsel.cds.ExpDate;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@Builder
@ToString(exclude = {"pan", "cvv2", "expDate"})
public class EntryStateModel {

    private String merchantUid;
    private String merchantSite;
    private String pan;
    private ExpDate expDate;
    private String cvv2;
    private String amount;
    private Short currency;
    private String modifiers;
    private String cardName;
    private String orderId;
    private String ip;
    private String email;
    private String country;
    private String city;
    private String region;
    private String address;
    private String phone;
    private String callbackUrl;
    private String trxId;
    private String key;
    private String refundId;
    private String recToken;
    private TargetStatus targetStatus;
    private boolean makeRecurrent;
    private AdapterContext adapterContext;

    private Map<String, String> parameters;

    private Step step;
}
