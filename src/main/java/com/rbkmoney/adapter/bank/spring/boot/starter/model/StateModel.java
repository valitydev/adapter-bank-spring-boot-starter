package com.rbkmoney.adapter.bank.spring.boot.starter.model;

import com.rbkmoney.adapter.bank.spring.boot.starter.constants.TargetStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StateModel {

    private String recToken;
    private TargetStatus targetStatus;
    private boolean makeRecurrent;
    private AdapterContext adapterContext;

    private Step step;

}
