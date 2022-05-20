package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.bank.spring.boot.starter.configuration.properties.BenderClientProperties;
import dev.vality.adapter.common.bender.BenderClient;
import dev.vality.adapter.flow.lib.service.IdGenerator;
import dev.vality.bender.BenderSrv;
import dev.vality.woody.thrift.impl.http.THSpawnClientBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@EnableConfigurationProperties({BenderClientProperties.class})
public class BenderConfiguration {

    @Bean
    public BenderSrv.Iface benderSrv(BenderClientProperties properties) throws IOException {
        return new THSpawnClientBuilder()
                .withAddress(properties.getUrl().getURI())
                .withNetworkTimeout(properties.getNetworkTimeout())
                .build(BenderSrv.Iface.class);
    }

    @Bean
    public BenderClient benderClient(BenderSrv.Iface benderSrv, BenderClientProperties properties) {
        return new BenderClient(benderSrv, properties.getNamespace());
    }

    @Bean
    public IdGenerator idGenerator(BenderSrv.Iface benderSrv) {
        return new IdGenerator(benderSrv);
    }
}
