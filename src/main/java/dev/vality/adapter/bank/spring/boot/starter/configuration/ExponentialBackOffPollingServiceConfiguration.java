package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.service.ExponentialBackOffPollingService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.exponentialBackOffPollingService.enabled:true}")
public class ExponentialBackOffPollingServiceConfiguration {

    @Bean
    public ExponentialBackOffPollingService exponentialBackOffPollingService() {
        return new ExponentialBackOffPollingService();
    }
}
