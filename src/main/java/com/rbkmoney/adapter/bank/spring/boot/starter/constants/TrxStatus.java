package com.rbkmoney.adapter.bank.spring.boot.starter.constants;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public enum TrxStatus {

    INIT(0),
    DECLINED(1),
    AUTHORIZED(2),
    CAPTURED(3),
    RECONCILED(4),
    SETTLED(5);

    private final Integer code;
    private static final Map<Integer, TrxStatus> valueMap = new HashMap<>();

    static {
        for (TrxStatus value : TrxStatus.values()) {
            valueMap.put(value.code, value);
        }
    }

    public static TrxStatus statusByCode(Integer code) {
        return valueMap.get(code);
    }
}
