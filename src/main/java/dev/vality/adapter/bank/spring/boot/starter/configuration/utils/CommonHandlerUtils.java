package dev.vality.adapter.bank.spring.boot.starter.configuration.utils;

import dev.vality.adapter.flow.lib.client.RemoteClient;
import dev.vality.adapter.flow.lib.converter.base.EntryModelToBaseRequestModelConverter;
import dev.vality.adapter.flow.lib.handler.CommonHandler;
import dev.vality.adapter.flow.lib.handler.payment.*;
import dev.vality.adapter.flow.lib.model.BaseResponseModel;
import dev.vality.adapter.flow.lib.model.EntryStateModel;
import dev.vality.adapter.flow.lib.model.ExitStateModel;
import dev.vality.adapter.flow.lib.processor.Processor;

import java.util.List;

public class CommonHandlerUtils {

    public static List<CommonHandler<ExitStateModel, EntryStateModel>> getHandlers(
            RemoteClient remoteClient,
            EntryModelToBaseRequestModelConverter entryModelToBaseRequestModelConverter,
            Processor<ExitStateModel, BaseResponseModel, EntryStateModel> baseProcessor) {
        return List.of(
                new AuthHandler(remoteClient, entryModelToBaseRequestModelConverter, baseProcessor),
                new CancelHandler(remoteClient, entryModelToBaseRequestModelConverter, baseProcessor),
                new CaptureHandler(remoteClient, entryModelToBaseRequestModelConverter, baseProcessor),
                new StatusHandler(remoteClient, entryModelToBaseRequestModelConverter, baseProcessor),
                new DoNothingHandler(),
                new PaymentHandler(remoteClient, entryModelToBaseRequestModelConverter, baseProcessor),
                new GenerateTokenHandler(remoteClient, entryModelToBaseRequestModelConverter, baseProcessor),
                new RefundHandler(remoteClient, entryModelToBaseRequestModelConverter, baseProcessor));
    }
}
