package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.handler.callback.PaymentCallbackHandler;
import dev.vality.adapter.flow.lib.serde.TemporaryContextDeserializer;
import dev.vality.adapter.flow.lib.serde.TemporaryContextSerializer;
import dev.vality.adapter.flow.lib.service.TemporaryContextService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentCallbackHandlerConfiguration {

    @Bean
    public PaymentCallbackHandler paymentCallbackHandler(
            TemporaryContextDeserializer temporaryContextDeserializer,
            TemporaryContextSerializer temporaryContextSerializer,
            TemporaryContextService temporaryContextService) {
        return new PaymentCallbackHandler(
                temporaryContextDeserializer,
                temporaryContextSerializer,
                temporaryContextService);
    }
}
