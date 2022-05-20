package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.converter.ExitStateModelToTemporaryContextConverter;
import dev.vality.adapter.flow.lib.converter.exit.ExitModelToRecTokenProxyResultConverter;
import dev.vality.adapter.flow.lib.flow.RecurrentResultIntentResolver;
import dev.vality.adapter.flow.lib.serde.TemporaryContextSerializer;
import dev.vality.adapter.flow.lib.service.RecurrentIntentResultFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExitModelToRecTokenProxyResultConverterConfiguration {

    @Bean
    public ExitModelToRecTokenProxyResultConverter exitModelToRecTokenProxyResultConverter(
            RecurrentIntentResultFactory recurrentIntentResultFactory,
            TemporaryContextSerializer temporaryContextSerializer,
            RecurrentResultIntentResolver recurrentResultIntentResolver,
            ExitStateModelToTemporaryContextConverter exitStateModelToTemporaryContextConverter) {
        return new ExitModelToRecTokenProxyResultConverter(
                recurrentIntentResultFactory,
                temporaryContextSerializer,
                recurrentResultIntentResolver,
                exitStateModelToTemporaryContextConverter);
    }
}
