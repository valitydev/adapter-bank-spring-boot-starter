package dev.vality.adapter.bank.spring.boot.starter.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;

@SuppressWarnings({"all"})
@SpringBootTest(classes = {
        RemoteClientImpl.class,
        Validator.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.SimpleObjectMapperConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.SimpleErrorMappingConfiguration.class,
//        dev.vality.adapter.bank.spring.boot.starter.configuration.RestTemplateConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.RequestLoggingAspectConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.NetworkConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.LoggingInterceptorConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.HellgateClientConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.CdsStorageClientConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.CdsIdStorageClientConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.BenderConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.AdapterConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.TimerConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.SerdeConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.ProcessorConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.CtxToEntryModelConverterConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.EntryModelToBaseRequestModelConverterConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.ExitModelToProxyResultConverterConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.ExitModelToRecTokenProxyResultConverterConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.ExitStateModelToTemporaryContextConverterConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.ExponentialBackOffPollingServiceConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.IntentResultFactoryConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.PaymentCallbackHandlerConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.PaymentServerFlowHandlerConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.RecCtxToEntryModelConverterConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.RecurrentIntentResultFactoryConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.RecurrentResultIntentResolverConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.RecurrentTokenCallbackHandlerConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.ResultIntentResolverConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.ServerHandlerLogDecoratorConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.StepResolverConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.TemporaryContextServiceConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.ThreeDsAdapterServiceConfiguration.class,
        dev.vality.adapter.bank.spring.boot.starter.configuration.TokenServerFlowHandlerConfiguration.class})
@PropertySource("classpath:application.yml")
public class StarterTest {

    @Test
    public void build() {
    }
}
