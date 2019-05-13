package com.rbkmoney.adapter.bank.spring.boot.starter.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExitStateModel {

    private Step nextStep;
    private String errorCode;
    private String errorMessage;
    private AdapterContext adapterContext;
    private EntryStateModel entryStateModel;
    private String pareq;
    private String refundId;
    private String md;
    private String acsUrl;
    private Long txnId;
    private Long newTxnId;

}
