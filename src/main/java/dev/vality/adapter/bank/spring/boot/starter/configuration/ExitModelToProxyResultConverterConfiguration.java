package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.converter.ExitStateModelToTemporaryContextConverter;
import dev.vality.adapter.flow.lib.converter.exit.ExitModelToProxyResultConverter;
import dev.vality.adapter.flow.lib.flow.ResultIntentResolver;
import dev.vality.adapter.flow.lib.serde.TemporaryContextSerializer;
import dev.vality.adapter.flow.lib.service.IntentResultFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.exitModelToProxyResultConverter.enabled:true}")
public class ExitModelToProxyResultConverterConfiguration {

    @Bean
    public ExitModelToProxyResultConverter exitModelToProxyResultConverter(
            IntentResultFactory intentResultFactory,
            TemporaryContextSerializer temporaryContextSerializer,
            ResultIntentResolver resultIntentResolver,
            ExitStateModelToTemporaryContextConverter exitStateModelToTemporaryContextConverter) {
        return new ExitModelToProxyResultConverter(
                intentResultFactory,
                temporaryContextSerializer,
                resultIntentResolver,
                exitStateModelToTemporaryContextConverter);
    }
}
