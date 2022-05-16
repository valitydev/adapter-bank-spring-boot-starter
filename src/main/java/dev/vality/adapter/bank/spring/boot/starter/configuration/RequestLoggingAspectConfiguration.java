package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.common.component.RequestLoggingAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.request-logging-aspect.enabled:true}")
public class RequestLoggingAspectConfiguration {

    @Bean
    public RequestLoggingAspect requestLoggingAspect() {
        return new RequestLoggingAspect();
    }
}
