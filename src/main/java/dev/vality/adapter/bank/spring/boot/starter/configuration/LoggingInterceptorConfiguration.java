package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.common.component.LoggingInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.logging-interceptor.enabled:false}")
public class LoggingInterceptorConfiguration {

    @Bean
    public LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }
}
