package com.rbkmoney.adapter.bank.spring.boot.starter.serializer;

public interface Serializer<TState> {
    byte[] writeByte(Object obj);

    String writeString(Object obj);

    TState read(byte[] data);

    TState read(String data);
}
