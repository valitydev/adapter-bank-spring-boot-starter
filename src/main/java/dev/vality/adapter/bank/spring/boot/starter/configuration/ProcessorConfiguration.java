package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.model.BaseResponseModel;
import dev.vality.adapter.flow.lib.model.EntryStateModel;
import dev.vality.adapter.flow.lib.model.ExitStateModel;
import dev.vality.adapter.flow.lib.processor.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessorConfiguration {

    @Bean
    public Processor<ExitStateModel, BaseResponseModel, EntryStateModel> baseProcessor() {
        ErrorProcessor errorProcessor = new ErrorProcessor();
        SuccessFinishProcessor baseProcessor = new SuccessFinishProcessor(errorProcessor);
        RedirectProcessor redirectProcessor = new RedirectProcessor(baseProcessor);
        return new RetryProcessor(redirectProcessor);
    }
}
