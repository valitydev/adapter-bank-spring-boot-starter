package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.converter.base.EntryModelToBaseRequestModelConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntryModelToBaseRequestModelConverterConfiguration {

    @Bean
    public EntryModelToBaseRequestModelConverter entryModelToBaseRequestModelConverter() {
        return new EntryModelToBaseRequestModelConverter();
    }
}
