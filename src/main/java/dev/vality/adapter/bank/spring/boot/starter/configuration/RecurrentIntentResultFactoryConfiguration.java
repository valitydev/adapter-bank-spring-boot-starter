package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.common.mapper.ErrorMapping;
import dev.vality.adapter.flow.lib.service.ExponentialBackOffPollingService;
import dev.vality.adapter.flow.lib.service.PollingInfoService;
import dev.vality.adapter.flow.lib.service.RecurrentIntentResultFactory;
import dev.vality.adapter.flow.lib.service.TagManagementService;
import dev.vality.adapter.flow.lib.utils.CallbackUrlExtractor;
import dev.vality.adapter.flow.lib.utils.TimerProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.recurrentIntentResultFactory.enabled:true}")
public class RecurrentIntentResultFactoryConfiguration {

    @Bean
    public RecurrentIntentResultFactory recurrentIntentResultFactory(
            TimerProperties timerProperties,
            CallbackUrlExtractor callbackUrlExtractor,
            TagManagementService tagManagementService,
            PollingInfoService pollingInfoService,
            ErrorMapping errorMapping,
            ExponentialBackOffPollingService exponentialBackOffPollingService) {
        return new RecurrentIntentResultFactory(
                timerProperties,
                callbackUrlExtractor,
                tagManagementService,
                pollingInfoService,
                errorMapping,
                exponentialBackOffPollingService);
    }
}
