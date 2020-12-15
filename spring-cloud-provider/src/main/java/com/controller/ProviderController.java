package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;

@RestController
public class ProviderController {

	@RequestMapping("/provider/get/employee")
	public Employee getEmployee(HttpServletRequest request) {
//		System.out.println(request.get);
		Employee e = new Employee();
		e.setA(250);
		return e;
	}
	
	@RequestMapping("/provider/get/employee/feign")
	public Employee getEmployeeFeign() {
		Employee e = new Employee();
		e.setA(250);
		return e;
	}
}
