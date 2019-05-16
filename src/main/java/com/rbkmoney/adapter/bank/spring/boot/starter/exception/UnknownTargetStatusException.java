package com.rbkmoney.adapter.bank.spring.boot.starter.exception;

public class UnknownTargetStatusException extends RuntimeException {

    public UnknownTargetStatusException() {
        super("Unknown target status!");
    }
}
