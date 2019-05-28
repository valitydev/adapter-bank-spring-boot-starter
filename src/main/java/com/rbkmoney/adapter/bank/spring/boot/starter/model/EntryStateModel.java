package com.rbkmoney.adapter.bank.spring.boot.starter.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntryStateModel {

    private OperationModel operationModel;
    private StateModel stateModel;
    private TransactionInfo transactionInfo;

}
