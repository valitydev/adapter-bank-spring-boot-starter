package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.flow.ResultIntentResolver;
import dev.vality.adapter.flow.lib.flow.simple.SimpleRedirectWithPollingResultIntentResolver;
import dev.vality.adapter.flow.lib.service.IntentResultFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResultIntentResolverConfiguration {

    @Bean
    public ResultIntentResolver resultIntentResolver(IntentResultFactory intentResultFactory) {
        return new SimpleRedirectWithPollingResultIntentResolver(intentResultFactory);
    }
}
