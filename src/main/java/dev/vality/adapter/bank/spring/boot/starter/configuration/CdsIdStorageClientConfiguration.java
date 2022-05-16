package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.bank.spring.boot.starter.configuration.properties.CdsIdStorageClientProperties;
import dev.vality.adapter.common.cds.CdsIdStorageClient;
import dev.vality.damsel.identity_document_storage.IdentityDocumentStorageSrv;
import dev.vality.woody.thrift.impl.http.THSpawnClientBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@EnableConfigurationProperties(CdsIdStorageClientProperties.class)
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.cds-id-storage-client.enabled:true}")
public class CdsIdStorageClientConfiguration {

    @Bean
    public IdentityDocumentStorageSrv.Iface identityDocumentStorageSrv(CdsIdStorageClientProperties properties)
            throws IOException {
        return new THSpawnClientBuilder()
                .withAddress(properties.getUrl().getURI())
                .withNetworkTimeout(properties.getNetworkTimeout())
                .build(IdentityDocumentStorageSrv.Iface.class);
    }

    @Bean
    public CdsIdStorageClient cdsIdStorageClient(IdentityDocumentStorageSrv.Iface identityDocumentStorageSrv) {
        return new CdsIdStorageClient(identityDocumentStorageSrv);
    }
}
