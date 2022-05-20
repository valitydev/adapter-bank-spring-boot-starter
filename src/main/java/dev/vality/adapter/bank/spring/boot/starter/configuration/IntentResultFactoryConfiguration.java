package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.common.mapper.ErrorMapping;
import dev.vality.adapter.flow.lib.serde.ParametersSerializer;
import dev.vality.adapter.flow.lib.service.ExponentialBackOffPollingService;
import dev.vality.adapter.flow.lib.service.IntentResultFactory;
import dev.vality.adapter.flow.lib.service.PollingInfoService;
import dev.vality.adapter.flow.lib.service.TagManagementService;
import dev.vality.adapter.flow.lib.utils.CallbackUrlExtractor;
import dev.vality.adapter.flow.lib.utils.TimerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IntentResultFactoryConfiguration {

    @Bean
    public IntentResultFactory intentResultFactory(
            TimerProperties timerProperties,
            CallbackUrlExtractor callbackUrlExtractor,
            TagManagementService tagManagementService,
            ParametersSerializer parametersSerializer,
            PollingInfoService pollingInfoService,
            ErrorMapping errorMapping,
            ExponentialBackOffPollingService exponentialBackOffPollingService) {
        return new IntentResultFactory(
                timerProperties,
                callbackUrlExtractor,
                tagManagementService,
                parametersSerializer,
                pollingInfoService,
                errorMapping,
                exponentialBackOffPollingService);
    }
}
