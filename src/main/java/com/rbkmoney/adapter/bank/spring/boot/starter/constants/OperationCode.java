package com.rbkmoney.adapter.bank.spring.boot.starter.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OperationCode {

    SALE(1),
    FINISH_THREE_DS(2),
    AUTH(3),
    CAPTURED(5),
    REVERSAL(6),
    REFUND(7),
    RECURRING_INIT_SALE(10),
    RECURRING_INIT_AUTH(11),
    RECURRING_SALE(12),
    STATUS(30);

    private final Integer code;

}
