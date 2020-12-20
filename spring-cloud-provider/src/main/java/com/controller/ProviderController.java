package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.util.ResultEntity;

/**
 * @author ZYZ
 *
 */
@RestController
public class ProviderController {

	
	/**
	 * eureka、ribbon调用测试方法
	 * @param request
	 * @return
	 */
	@RequestMapping("/provider/get/employee")
	public Employee getEmployee(HttpServletRequest request) {
		Employee e = new Employee();
		e.setA(250);
		return e;
	}
	
	/**
	 * feign调用测试方法
	 * @return
	 */
	@RequestMapping("/provider/get/employee/feign")
	public Employee getEmployeeFeign() {
		Employee e = new Employee();
		e.setA(250);
		return e;
	}
	
	/**
	 * hystrix测试调用方法
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "getEmployeeHystrixError")//配置熔断，出错时的处理方法
	@RequestMapping("/provider/get/employee/hystrix")
	public ResultEntity<Employee> getEmployeeHystrix() {
		
//		int i = 250;
		int i = 10/0; //报错
		
		Employee e = new Employee();
		e.setA(i);
		return ResultEntity.successWithData(e);
	}
	
	public ResultEntity<Employee> getEmployeeHystrixError() {
		Employee e = new Employee();
		e.setA(250);
		return ResultEntity.failed("getEmployeeHystrix error");
	}
}
