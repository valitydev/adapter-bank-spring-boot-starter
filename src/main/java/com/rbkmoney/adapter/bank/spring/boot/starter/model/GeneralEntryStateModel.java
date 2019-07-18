package com.rbkmoney.adapter.bank.spring.boot.starter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneralEntryStateModel {

    private OperationModel operationModel;
    private StateModel stateModel;
    private TransactionInfo transactionInfo;

}
