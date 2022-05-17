package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.flow.RecurrentResultIntentResolver;
import dev.vality.adapter.flow.lib.flow.simple.SimpleRedirectGenerateTokenResultIntentResolver;
import dev.vality.adapter.flow.lib.service.RecurrentIntentResultFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.recurrentResultIntentResolver.enabled:true}")
public class RecurrentResultIntentResolverConfiguration {

    @Bean
    public RecurrentResultIntentResolver recurrentResultIntentResolver(
            RecurrentIntentResultFactory recurrentIntentResultFactory) {
        return new SimpleRedirectGenerateTokenResultIntentResolver(recurrentIntentResultFactory);
    }
}
