package com.EurekaServerMyCabBuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMyCabBuddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerMyCabBuddyApplication.class, args);
		System.out.println("Eureka Server for *My Cab Buddy* app is UP.");
	}

}
