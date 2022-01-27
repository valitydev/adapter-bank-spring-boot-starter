package dev.vality.adapter.bank.spring.boot.starter.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.vality.adapter.common.state.serializer.AdapterSerializer;
import dev.vality.adapter.common.state.serializer.CallbackSerializer;
import dev.vality.adapter.common.state.serializer.RecurrentTokenSerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SerializerConfiguration {

    @Bean
    public CallbackSerializer callbackSerializer(ObjectMapper objectMapper) {
        return new CallbackSerializer(objectMapper);
    }

    @Bean
    public AdapterSerializer adapterSerializer(ObjectMapper objectMapper) {
        return new AdapterSerializer(objectMapper);
    }

    @Bean
    public RecurrentTokenSerializer recTokenSerializer(ObjectMapper objectMapper) {
        return new RecurrentTokenSerializer(objectMapper);
    }

}
