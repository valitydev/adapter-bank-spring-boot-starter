package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.bank.spring.boot.starter.configuration.properties.HellgateClientProperties;
import dev.vality.adapter.common.hellgate.HellgateClient;
import dev.vality.damsel.proxy_provider.ProviderProxyHostSrv;
import dev.vality.woody.thrift.impl.http.THSpawnClientBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@EnableConfigurationProperties({HellgateClientProperties.class})
@ConditionalOnExpression("${adapter-bank-spring-boot-starter.hellgate-client.enabled:true}")
public class HellgateClientConfiguration {

    @Bean
    public ProviderProxyHostSrv.Iface providerProxyHostSrv(HellgateClientProperties properties) throws IOException {
        return new THSpawnClientBuilder()
                .withAddress(properties.getUrl().getURI())
                .withNetworkTimeout(properties.getNetworkTimeout())
                .build(ProviderProxyHostSrv.Iface.class);
    }

    @Bean
    public HellgateClient hellgateClient(ProviderProxyHostSrv.Iface providerProxyHostSrv) {
        return new HellgateClient(providerProxyHostSrv);
    }
}
