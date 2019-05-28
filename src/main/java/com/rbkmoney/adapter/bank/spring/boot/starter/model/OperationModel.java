package com.rbkmoney.adapter.bank.spring.boot.starter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class OperationModel {

    @ToString.Exclude
    private String pan;
    @ToString.Exclude
    private Byte expMonth;
    @ToString.Exclude
    private Short expYear;
    @ToString.Exclude
    private String cvv2;
    @ToString.Exclude
    private String cardHolder;

    private String cryptogram;
    private String eci;

    private Long amount;
    private Short currencyCode;
    private String currencySymbolCode;
    private String createdAt;

    private String ip;
    private String email;
    private String phone;

    private Long refundAmount;
    private String refundId;
    private String invoiceDetails;
    private String callbackUrl;

    private Map<String, String> options;

}
