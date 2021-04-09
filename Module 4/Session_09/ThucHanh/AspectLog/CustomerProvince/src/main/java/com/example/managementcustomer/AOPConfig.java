package com.example.managementcustomer;

import com.example.managementcustomer.aop.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AOPConfig {
    @Bean
    public Logger logger() {
        return new Logger();
    }
}

