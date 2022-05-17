package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.serde.ParametersDeserializer;
import dev.vality.adapter.flow.lib.service.TemporaryContextService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.temporaryContextService.enabled:true}")
public class TemporaryContextServiceConfiguration {

    @Bean
    public TemporaryContextService temporaryContextService(ParametersDeserializer parametersDeserializer) {
        return new TemporaryContextService(parametersDeserializer);
    }
}
