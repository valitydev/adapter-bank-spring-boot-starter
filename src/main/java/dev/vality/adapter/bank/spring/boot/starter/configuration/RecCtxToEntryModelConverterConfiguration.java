package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.common.cds.CdsStorageClient;
import dev.vality.adapter.flow.lib.converter.entry.RecCtxToEntryModelConverter;
import dev.vality.adapter.flow.lib.serde.TemporaryContextDeserializer;
import dev.vality.adapter.flow.lib.service.IdGenerator;
import dev.vality.adapter.flow.lib.service.TemporaryContextService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.recCtxToEntryModelConverter.enabled:true}")
public class RecCtxToEntryModelConverterConfiguration {

    @Bean
    public RecCtxToEntryModelConverter recCtxToEntryModelConverter(
            CdsStorageClient cdsStorageClient,
            TemporaryContextDeserializer temporaryContextDeserializer,
            IdGenerator idGenerator,
            TemporaryContextService temporaryContextService) {
        return new RecCtxToEntryModelConverter(
                temporaryContextDeserializer,
                cdsStorageClient,
                idGenerator,
                temporaryContextService);
    }
}
