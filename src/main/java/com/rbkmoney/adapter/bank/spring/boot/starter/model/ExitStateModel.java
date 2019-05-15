package com.rbkmoney.adapter.bank.spring.boot.starter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private String trxId;
    private String lastOpId;

}
