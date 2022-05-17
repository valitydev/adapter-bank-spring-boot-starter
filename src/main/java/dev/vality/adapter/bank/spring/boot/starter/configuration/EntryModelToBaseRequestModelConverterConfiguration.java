package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.converter.base.EntryModelToBaseRequestModelConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.entryModelToBaseRequestModelConverter.enabled:true}")
public class EntryModelToBaseRequestModelConverterConfiguration {

    @Bean
    public EntryModelToBaseRequestModelConverter entryModelToBaseRequestModelConverter() {
        return new EntryModelToBaseRequestModelConverter();
    }
}
