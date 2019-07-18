package com.rbkmoney.adapter.bank.spring.boot.starter.model;

import com.rbkmoney.adapter.common.enums.Step;
import com.rbkmoney.adapter.common.enums.TargetStatus;
import com.rbkmoney.adapter.common.model.AdapterContext;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StateModel {

    private AdapterContext adapterContext;
    private TargetStatus targetStatus;
    private Step step;
    private Step nextStep;

    private String recToken;
    private boolean makeRecurrent;

    private String cryptogram;
    private String eci;

}
