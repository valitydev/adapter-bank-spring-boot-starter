package com.rbkmoney.adapter.bank.spring.boot.starter.processor;

import com.rbkmoney.adapter.bank.spring.boot.starter.model.EntryStateModel;

public interface Processor<T, R> {

    T process(R response, EntryStateModel context);

}
