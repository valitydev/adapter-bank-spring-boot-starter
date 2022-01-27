package dev.vality.adapter.bank.spring.boot.starter.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.vality.adapter.common.state.deserializer.AdapterDeserializer;
import dev.vality.adapter.common.state.deserializer.CallbackDeserializer;
import dev.vality.adapter.common.state.deserializer.RecurrentTokenDeserializer;
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
    public RecurrentTokenDeserializer recTokenDeserializer(ObjectMapper objectMapper) {
        return new RecurrentTokenDeserializer(objectMapper);
    }

}
