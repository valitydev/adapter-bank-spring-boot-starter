package com.rbkmoney.adapter.bank.spring.boot.starter.exception;

import org.apache.thrift.TException;

public class UnsupportedMethodException extends TException {

    public UnsupportedMethodException() {
        super("Unsupported method");
    }
}
