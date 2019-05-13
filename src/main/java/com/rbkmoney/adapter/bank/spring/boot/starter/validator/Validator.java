package com.rbkmoney.adapter.bank.spring.boot.starter.validator;

public interface Validator<T> {
    void validate(T request);
}
