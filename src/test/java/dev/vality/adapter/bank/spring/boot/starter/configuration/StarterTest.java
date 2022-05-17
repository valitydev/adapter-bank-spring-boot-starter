package dev.vality.adapter.bank.spring.boot.starter.configuration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application.yml")
@ComponentScan("dev.vality.adapter.bank.spring.boot.starter.configuration")
public class StarterTest {

    @Test
    public void build() {
    }
}
