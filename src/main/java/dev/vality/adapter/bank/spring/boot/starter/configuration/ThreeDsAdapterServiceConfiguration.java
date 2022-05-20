package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.common.hellgate.HellgateClient;
import dev.vality.adapter.flow.lib.serde.ParametersDeserializer;
import dev.vality.adapter.flow.lib.serde.ParametersSerializer;
import dev.vality.adapter.flow.lib.service.TagManagementService;
import dev.vality.adapter.flow.lib.service.ThreeDsAdapterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThreeDsAdapterServiceConfiguration {

    @Bean
    public ThreeDsAdapterService threeDsAdapterService(
            HellgateClient hellgateClient,
            ParametersSerializer parametersSerializer,
            ParametersDeserializer parametersDeserializer,
            TagManagementService tagManagementService) {
        return new ThreeDsAdapterService(
                hellgateClient,
                parametersSerializer,
                parametersDeserializer,
                tagManagementService);
    }
}
