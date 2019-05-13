package com.rbkmoney.adapter.bank.spring.boot.starter.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public enum TrxType {

    AUTH(2),
    REFUND(3),
    REVERSAL(4),
    RECURRING(5),
    RECURRING_INIT(6),
    RECURRING_AUTH(7);

    private final Integer code;
    private static final Map<Integer, TrxType> valueMap = new HashMap<>();

    static {
        for (TrxType value : TrxType.values()) {
            valueMap.put(value.code, value);
        }
    }

    public static TrxType statusByCode(Integer code) {
        return valueMap.get(code);
    }
}
