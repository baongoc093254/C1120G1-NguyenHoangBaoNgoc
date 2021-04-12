package com.example.managementcustomer;

import com.example.managementcustomer.repository.CustomerRepository;
import com.example.managementcustomer.repository.impl.CustomerRepositoryImpl;
import com.example.managementcustomer.service.CustomerService;
import com.example.managementcustomer.service.impl.CustomerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManagementcustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementcustomerApplication.class, args);
    }

    @Bean
    public CustomerRepository customerRepository(){
        return new CustomerRepositoryImpl();
    }

    @Bean
    public CustomerService customerService(){
        return new CustomerServiceImpl();
    }
}
