package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.bank.spring.boot.starter.configuration.utils.CommonHandlerUtils;
import dev.vality.adapter.flow.lib.client.RemoteClient;
import dev.vality.adapter.flow.lib.converter.base.EntryModelToBaseRequestModelConverter;
import dev.vality.adapter.flow.lib.converter.entry.RecCtxToEntryModelConverter;
import dev.vality.adapter.flow.lib.converter.exit.ExitModelToRecTokenProxyResultConverter;
import dev.vality.adapter.flow.lib.flow.simple.GenerateTokenSimpleRedirectWithPollingStepResolverImpl;
import dev.vality.adapter.flow.lib.handler.ServerFlowHandler;
import dev.vality.adapter.flow.lib.model.BaseResponseModel;
import dev.vality.adapter.flow.lib.model.EntryStateModel;
import dev.vality.adapter.flow.lib.model.ExitStateModel;
import dev.vality.adapter.flow.lib.processor.Processor;
import dev.vality.damsel.proxy_provider.RecurrentTokenContext;
import dev.vality.damsel.proxy_provider.RecurrentTokenProxyResult;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.tokenServerFlowHandler.enabled:true}")
public class TokenServerFlowHandlerConfiguration {

    @Bean
    public ServerFlowHandler<RecurrentTokenContext, RecurrentTokenProxyResult> tokenServerFlowHandler(
            RemoteClient remoteClient,
            EntryModelToBaseRequestModelConverter entryModelToBaseRequestModelConverter,
            Processor<ExitStateModel, BaseResponseModel, EntryStateModel> baseProcessor,
            GenerateTokenSimpleRedirectWithPollingStepResolverImpl generateTokenSimpleRedirectWithPollingStepResolver,
            RecCtxToEntryModelConverter recCtxToEntryStateModelConverter,
            ExitModelToRecTokenProxyResultConverter exitModelToRecTokenProxyResultConverter) {
        return new ServerFlowHandler<>(
                CommonHandlerUtils.getHandlers(remoteClient, entryModelToBaseRequestModelConverter, baseProcessor),
                generateTokenSimpleRedirectWithPollingStepResolver,
                recCtxToEntryStateModelConverter,
                exitModelToRecTokenProxyResultConverter);
    }
}
