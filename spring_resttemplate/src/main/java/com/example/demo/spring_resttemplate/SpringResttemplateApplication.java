package com.example.demo.spring_resttemplate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringResttemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringResttemplateApplication.class, args);
		FetchApi fetchApi = null;
		fetchApi.getRequest();
	}
}

