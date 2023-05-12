package com.example.demo.config;

import com.example.demo.aca.AriesClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

    @Bean
    public AriesClient issuerClient() {
        return new AriesClient("localhost:11000", new RestTemplate());
    }

    @Bean
    public AriesClient holderClient() {
        return new AriesClient("http://localhost:11001", new RestTemplate());
    }

    @Bean
    public AriesClient verifierClient() {
        return new AriesClient("http://localhost:11001", new RestTemplate());
    }

}
