package com.FareCalcuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class FareCalcuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FareCalcuatorApplication.class, args);
		System.out.println("Fare Calculator Service is UP.");
	}
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
