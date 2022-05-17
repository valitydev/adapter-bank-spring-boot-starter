package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.bank.spring.boot.starter.configuration.properties.AdapterProperties;
import dev.vality.adapter.flow.lib.service.TagManagementService;
import dev.vality.adapter.flow.lib.utils.CallbackUrlExtractor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({AdapterProperties.class})
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.adapter.enabled:true}")
public class AdapterConfiguration {

    @Bean
    public TagManagementService tagManagementService(
            dev.vality.adapter.flow.lib.utils.AdapterProperties adapterProperties) {
        return new TagManagementService(adapterProperties);
    }

    @Bean
    public CallbackUrlExtractor callbackUrlExtractor(
            dev.vality.adapter.flow.lib.utils.AdapterProperties adapterProperties) {
        return new CallbackUrlExtractor(adapterProperties);
    }
}
