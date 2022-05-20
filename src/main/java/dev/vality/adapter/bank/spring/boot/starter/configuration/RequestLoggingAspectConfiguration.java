package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.common.component.RequestLoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestLoggingAspectConfiguration {

    @Bean
    public RequestLoggingAspect requestLoggingAspect() {
        return new RequestLoggingAspect();
    }
}
