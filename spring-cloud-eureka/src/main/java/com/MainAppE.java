package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer //����eureka����˹���
@SpringBootApplication
public class MainAppE {
	public static void main(String[] args) {
		SpringApplication.run(MainAppE.class,args);
	}
}
