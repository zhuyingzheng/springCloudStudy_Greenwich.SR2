package com.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConsumerConfig {
	
	@Bean
	@LoadBalanced //���ע����RestTemplate�и��ؾ���Ĺ��ܣ�ͨ������ribbon����provide��Ⱥ
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
