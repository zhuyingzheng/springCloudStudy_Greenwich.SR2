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
	 * eureka��ribbon���ò��Է���
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
	 * feign���ò��Է���
	 * @return
	 */
	@RequestMapping("/provider/get/employee/feign")
	public Employee getEmployeeFeign() {
		Employee e = new Employee();
		e.setA(250);
		return e;
	}
	
	/**
	 * hystrix���Ե��÷���
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "getEmployeeHystrixError")//�����۶ϣ�����ʱ�Ĵ�����
	@RequestMapping("/provider/get/employee/hystrix")
	public ResultEntity<Employee> getEmployeeHystrix() {
		
//		int i = 250;
		int i = 10/0; //����
		
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
