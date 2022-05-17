package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.common.cds.CdsStorageClient;
import dev.vality.adapter.flow.lib.converter.entry.CtxToEntryModelConverter;
import dev.vality.adapter.flow.lib.serde.TemporaryContextDeserializer;
import dev.vality.adapter.flow.lib.service.IdGenerator;
import dev.vality.adapter.flow.lib.service.TemporaryContextService;
import dev.vality.adapter.flow.lib.utils.CallbackUrlExtractor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.ctxToEntryModelConverter.enabled:true}")
public class CtxToEntryModelConverterConfiguration {

    @Bean
    public CtxToEntryModelConverter ctxToEntryModelConverter(
            CdsStorageClient cdsStorageClient,
            TemporaryContextDeserializer temporaryContextDeserializer,
            IdGenerator idGenerator,
            TemporaryContextService temporaryContextService,
            CallbackUrlExtractor callbackUrlExtractor) {
        return new CtxToEntryModelConverter(
                cdsStorageClient,
                temporaryContextDeserializer,
                idGenerator,
                temporaryContextService,
                callbackUrlExtractor);
    }
}
