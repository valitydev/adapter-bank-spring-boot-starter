package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.handler.ProxyProviderServiceImpl;
import dev.vality.adapter.flow.lib.handler.ServerFlowHandler;
import dev.vality.adapter.flow.lib.handler.ServerHandlerLogDecorator;
import dev.vality.adapter.flow.lib.handler.callback.PaymentCallbackHandler;
import dev.vality.adapter.flow.lib.handler.callback.RecurrentTokenCallbackHandler;
import dev.vality.adapter.flow.lib.validator.AdapterConfigurationValidator;
import dev.vality.damsel.proxy_provider.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.serverHandlerLogDecorator.enabled:true}")
public class ServerHandlerLogDecoratorConfiguration {

    @Bean
    public ProviderProxySrv.Iface serverHandlerLogDecorator(
            PaymentCallbackHandler paymentCallbackHandler,
            RecurrentTokenCallbackHandler recurrentTokenCallbackHandler,
            ServerFlowHandler<PaymentContext, PaymentProxyResult> paymentServerFlowHandler,
            ServerFlowHandler<RecurrentTokenContext, RecurrentTokenProxyResult> tokenServerFlowHandler,
            AdapterConfigurationValidator adapterConfigurationValidator) {
        return new ServerHandlerLogDecorator(new ProxyProviderServiceImpl(
                paymentCallbackHandler,
                recurrentTokenCallbackHandler,
                paymentServerFlowHandler,
                tokenServerFlowHandler,
                adapterConfigurationValidator));
    }
}
