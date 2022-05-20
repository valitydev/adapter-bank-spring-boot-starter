package dev.vality.adapter.bank.spring.boot.starter.configuration;

import dev.vality.adapter.flow.lib.validator.AdapterConfigurationValidator;
import org.springframework.boot.test.context.TestComponent;

import java.util.Map;

@TestComponent
public class Validator implements AdapterConfigurationValidator {

    @Override
    public void validate(Map<String, String> map) {

    }
}
