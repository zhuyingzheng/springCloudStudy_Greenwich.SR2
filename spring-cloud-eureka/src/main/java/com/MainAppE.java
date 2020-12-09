package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer //启用eureka服务端功能
@SpringBootApplication
public class MainAppE {
	public static void main(String[] args) {
		SpringApplication.run(MainAppE.class,args);
	}
}
