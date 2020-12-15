package com.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConsumerConfig {
	
	@Bean
	@LoadBalanced //这个注解让RestTemplate有负载均衡的功能，通过调用ribbon访问provide集群
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
