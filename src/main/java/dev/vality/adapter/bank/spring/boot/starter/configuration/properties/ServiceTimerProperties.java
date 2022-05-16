package dev.vality.adapter.bank.spring.boot.starter.configuration.properties;

import dev.vality.adapter.flow.lib.utils.TimerProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
@ConfigurationProperties("time.config")
public class ServiceTimerProperties extends TimerProperties {

}
