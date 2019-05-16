package com.rbkmoney.adapter.bank.spring.boot.starter.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.adapter.bank.spring.boot.starter.model.RecurrentContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RecurrentContextSerializer extends StateSerializer<RecurrentContext> {

    public RecurrentContextSerializer(ObjectMapper mapper) {
        super(mapper);
    }

    public RecurrentContext read(byte[] data) {
        if (data == null) {
            return new RecurrentContext();
        }
        try {
            return getMapper().readValue(data, RecurrentContext.class);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
