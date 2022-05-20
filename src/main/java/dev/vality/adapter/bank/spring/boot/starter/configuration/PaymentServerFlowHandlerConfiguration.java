package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.bank.spring.boot.starter.configuration.utils.CommonHandlerUtils;
import dev.vality.adapter.flow.lib.client.RemoteClient;
import dev.vality.adapter.flow.lib.converter.base.EntryModelToBaseRequestModelConverter;
import dev.vality.adapter.flow.lib.converter.entry.CtxToEntryModelConverter;
import dev.vality.adapter.flow.lib.converter.exit.ExitModelToProxyResultConverter;
import dev.vality.adapter.flow.lib.flow.StepResolver;
import dev.vality.adapter.flow.lib.handler.ServerFlowHandler;
import dev.vality.adapter.flow.lib.model.BaseResponseModel;
import dev.vality.adapter.flow.lib.model.EntryStateModel;
import dev.vality.adapter.flow.lib.model.ExitStateModel;
import dev.vality.adapter.flow.lib.processor.Processor;
import dev.vality.damsel.proxy_provider.PaymentContext;
import dev.vality.damsel.proxy_provider.PaymentProxyResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentServerFlowHandlerConfiguration {

    @Bean
    public ServerFlowHandler<PaymentContext, PaymentProxyResult> paymentServerFlowHandler(
            RemoteClient remoteClient,
            EntryModelToBaseRequestModelConverter entryModelToBaseRequestModelConverter,
            Processor<ExitStateModel, BaseResponseModel, EntryStateModel> baseProcessor,
            StepResolver<EntryStateModel, ExitStateModel> stepResolver,
            CtxToEntryModelConverter ctxToEntryModelConverter,
            ExitModelToProxyResultConverter exitModelToProxyResultConverter) {
        return new ServerFlowHandler<>(
                CommonHandlerUtils.getHandlers(remoteClient, entryModelToBaseRequestModelConverter, baseProcessor),
                stepResolver,
                ctxToEntryModelConverter,
                exitModelToProxyResultConverter);
    }
}
