package com.rbkmoney.adapter.bank.spring.boot.starter.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.adapter.common.state.deserializer.AdapterDeserializer;
import com.rbkmoney.adapter.common.state.deserializer.CallbackDeserializer;
import com.rbkmoney.adapter.common.state.deserializer.RecTokenDeserializer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DeserializerConfiguration {

    @Bean
    public CallbackDeserializer callbackDeserializer(ObjectMapper objectMapper) {
        return new CallbackDeserializer(objectMapper);
    }

    @Bean
    public AdapterDeserializer adapterDeserializer(ObjectMapper objectMapper) {
        return new AdapterDeserializer(objectMapper);
    }

    @Bean
    public RecTokenDeserializer recTokenDeserializer(ObjectMapper objectMapper) {
        return new RecTokenDeserializer(objectMapper);
    }

}
