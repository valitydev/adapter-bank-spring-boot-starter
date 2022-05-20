package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.bank.spring.boot.starter.configuration.properties.TimerProperties;
import dev.vality.adapter.flow.lib.service.PollingInfoService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({TimerProperties.class})
public class TimerConfiguration {

    @Bean
    public PollingInfoService pollingInfoService(
            dev.vality.adapter.flow.lib.utils.TimerProperties timerProperties) {
        return new PollingInfoService(timerProperties);
    }
}
