package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.serde.ParametersDeserializer;
import dev.vality.adapter.flow.lib.service.TemporaryContextService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TemporaryContextServiceConfiguration {

    @Bean
    public TemporaryContextService temporaryContextService(ParametersDeserializer parametersDeserializer) {
        return new TemporaryContextService(parametersDeserializer);
    }
}
