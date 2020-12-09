package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HumanResourceHandler {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/consumer/get/object")
	public Object getObject() {
		String host = "http://localhost:1000";
		String url = "/provider/get/employee";
		
		return restTemplate.getForEntity(host+url, Object.class);
	}
}
