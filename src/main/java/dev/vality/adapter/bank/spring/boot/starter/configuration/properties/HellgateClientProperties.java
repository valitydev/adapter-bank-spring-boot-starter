package dev.vality.adapter.bank.spring.boot.starter.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "hellgate.client")
@Validated
@Getter
@Setter
public class HellgateClientProperties {

    @NotNull
    private Resource url;

    @NotNull
    private int networkTimeout = 5000;
}
