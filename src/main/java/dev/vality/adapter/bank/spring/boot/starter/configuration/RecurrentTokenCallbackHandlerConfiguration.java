package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.handler.callback.RecurrentTokenCallbackHandler;
import dev.vality.adapter.flow.lib.serde.TemporaryContextDeserializer;
import dev.vality.adapter.flow.lib.serde.TemporaryContextSerializer;
import dev.vality.adapter.flow.lib.service.TemporaryContextService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecurrentTokenCallbackHandlerConfiguration {

    @Bean
    public RecurrentTokenCallbackHandler recurrentTokenCallbackHandler(
            TemporaryContextDeserializer temporaryContextDeserializer,
            TemporaryContextSerializer temporaryContextSerializer,
            TemporaryContextService temporaryContextService) {
        return new RecurrentTokenCallbackHandler(
                temporaryContextDeserializer,
                temporaryContextSerializer,
                temporaryContextService);
    }
}
