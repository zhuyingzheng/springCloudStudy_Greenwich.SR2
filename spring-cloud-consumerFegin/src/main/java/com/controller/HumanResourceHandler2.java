package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.EmployeeRemoteService;
import com.entity.Employee;
import com.util.ResultEntity;

@RestController
public class HumanResourceHandler2 {
	
	@Autowired //装配调用远程微服务的接口
	private EmployeeRemoteService employeeRemoteService;
	
	@RequestMapping("/consumer/get/object2")
	public Object getObject() {
		return employeeRemoteService.getEmployeeFeign();
	}
	
	@RequestMapping("/consumer/get/employeeHystrix")
	public ResultEntity<Employee> getEmployeeHystrix(){
		return employeeRemoteService.getEmployeeHystrix();
	}
}
