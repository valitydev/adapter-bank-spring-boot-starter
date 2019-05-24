package com.rbkmoney.adapter.bank.spring.boot.starter.model;

public enum Step {

    PRE_AUTH,
    AUTH,
    RECURRENT,
    AUTH_RECURRENT,
    CANCEL,
    CHECK_STATUS,
    FINISH_THREE_DS,
    GENERATE_TOKEN_FINISH_THREE_DS,
    GENERATE_TOKEN_CHECK_STATUS,
    GENERATE_TOKEN_CAPTURE,
    GENERATE_TOKEN_REFUND,
    GENERATE_TOKEN_FINISH,
    CAPTURE,
    REFUND

}
