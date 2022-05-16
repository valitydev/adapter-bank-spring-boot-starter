package dev.vality.adapter.bank.spring.boot.starter.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("time.config")
@Validated
@Getter
@Setter
public class TimerProperties extends dev.vality.adapter.flow.lib.utils.TimerProperties {

}
