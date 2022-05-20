package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.converter.ExitStateModelToTemporaryContextConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExitStateModelToTemporaryContextConverterConfiguration {

    @Bean
    public ExitStateModelToTemporaryContextConverter exitStateModelToTemporaryContextConverter() {
        return new ExitStateModelToTemporaryContextConverter();
    }
}
