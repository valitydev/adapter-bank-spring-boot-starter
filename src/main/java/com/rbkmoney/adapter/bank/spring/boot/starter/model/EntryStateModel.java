package com.rbkmoney.adapter.bank.spring.boot.starter.model;

import com.rbkmoney.adapter.bank.spring.boot.starter.constants.TargetStatus;
import com.rbkmoney.damsel.cds.ExpDate;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Map;

@Data
@Builder
@ToString(exclude = {"pan", "cvv2", "expMonth", "expYear", "cardHolderName"})
public class EntryStateModel {

    private String pan;
    private Byte expMonth;
    private Short expYear;
    private String cvv2;
    private String cardHolderName;
    private Long amount;
    private Short currency;
    private String currencyCode;

    private String ip;
    private String email;
    private String phone;

    private String trxId;
    private Map<String, String> trxExtra;

    private String refundId;
    private Long refundAmount;
    private String invoiceDetails;
    private RecurrentContext recurrentContext;
    private TargetStatus targetStatus;
    private boolean makeRecurrent;
    private AdapterContext adapterContext;

    private Map<String, String> options;

    private Step step;
}
