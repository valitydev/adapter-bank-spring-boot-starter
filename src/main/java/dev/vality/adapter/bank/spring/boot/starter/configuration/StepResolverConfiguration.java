package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.flow.full.FullThreeDsAllVersionsStepResolverImpl;
import dev.vality.adapter.flow.lib.flow.full.GenerateTokenFullThreeDsAllVersionsStepResolverImpl;
import dev.vality.adapter.flow.lib.flow.simple.GenerateTokenSimpleRedirectWithPollingStepResolverImpl;
import dev.vality.adapter.flow.lib.flow.simple.SimpleRedirectWIthPollingStepResolverImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.stepResolver.enabled:true}")
public class StepResolverConfiguration {

    @Bean
    public SimpleRedirectWIthPollingStepResolverImpl simpleRedirectWIthPollingStepResolver() {
        return new SimpleRedirectWIthPollingStepResolverImpl();
    }

    @Bean
    public FullThreeDsAllVersionsStepResolverImpl fullThreeDsAllVersionsStepResolver() {
        return new FullThreeDsAllVersionsStepResolverImpl();
    }

    @Bean
    public GenerateTokenFullThreeDsAllVersionsStepResolverImpl generateTokenFullThreeDsAllVersionsStepResolver() {
        return new GenerateTokenFullThreeDsAllVersionsStepResolverImpl();
    }

    @Bean
    public GenerateTokenSimpleRedirectWithPollingStepResolverImpl generateTokenSimpleRedirectWithPollingStepResolver() {
        return new GenerateTokenSimpleRedirectWithPollingStepResolverImpl();
    }
}
