package com.BookingMyCabBuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = "com.BookingMyCabBuddy.bean")
public class BookingMyCabBuddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingMyCabBuddyApplication.class, args);
		System.out.println("Booking micro service main class loaded.");
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
