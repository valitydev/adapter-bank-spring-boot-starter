package com.rbkmoney.adapter.bank.spring.boot.starter.handler;

import com.rbkmoney.adapter.bank.spring.boot.starter.model.EntryStateModel;
import org.apache.thrift.TException;

public interface CommonHandler<T, R, E extends EntryStateModel> {

    boolean isHandle(final E entryStateModel);

    T handle(E context) throws TException;

}
