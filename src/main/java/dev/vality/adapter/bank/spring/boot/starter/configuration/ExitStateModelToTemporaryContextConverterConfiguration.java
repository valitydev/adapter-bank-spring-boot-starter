package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.converter.ExitStateModelToTemporaryContextConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.exitStateModelToTemporaryContextConverter.enabled:true}")
public class ExitStateModelToTemporaryContextConverterConfiguration {

    @Bean
    public ExitStateModelToTemporaryContextConverter exitStateModelToTemporaryContextConverter() {
        return new ExitStateModelToTemporaryContextConverter();
    }
}
