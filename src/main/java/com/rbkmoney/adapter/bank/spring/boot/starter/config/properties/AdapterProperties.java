package com.rbkmoney.adapter.bank.spring.boot.starter.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Configuration
@ConfigurationProperties("adapter")
@Validated
public class AdapterProperties {

    @NotEmpty
    private String url;

    @NotEmpty
    private String callbackUrl;

    @NotEmpty
    private String pathCallbackUrl;

    @NotEmpty
    private String pathRecurrentCallbackUrl;

    @NotEmpty
    private String tagPrefix;

}