package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.bank.spring.boot.starter.configuration.properties.CdsStorageClientProperties;
import dev.vality.adapter.common.cds.CdsStorageClient;
import dev.vality.cds.storage.StorageSrv;
import dev.vality.woody.thrift.impl.http.THSpawnClientBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@EnableConfigurationProperties({CdsStorageClientProperties.class})
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.cds-storage-client.enabled:true}")
public class CdsStorageClientConfiguration {

    @Bean
    public StorageSrv.Iface storageSrv(CdsStorageClientProperties properties) throws IOException {
        return new THSpawnClientBuilder()
                .withAddress(properties.getUrl().getURI())
                .withNetworkTimeout(properties.getNetworkTimeout())
                .build(StorageSrv.Iface.class);
    }

    @Bean
    public CdsStorageClient cdsStorageClient(StorageSrv.Iface storageSrv) {
        return new CdsStorageClient(storageSrv);
    }
}
