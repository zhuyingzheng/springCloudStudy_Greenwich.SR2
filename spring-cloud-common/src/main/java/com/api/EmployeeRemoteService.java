package com.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Employee;
import com.factory.MyFallBackFactory;
import com.util.ResultEntity;

//provider的微服务名称，包路径要和autowrite的包路径一致
//fallbackFactory指定provider不可用是的备选方案（Hystrix降级）
@FeignClient(value = "provider" , fallbackFactory = MyFallBackFactory.class) 
public interface EmployeeRemoteService {
	
	//远程调用的接口方法，
	//要求@RequestMapping注解映射的地址一致，
	//要求方法声明一致,
	//要求@RequestParam、@PathVariable、@RequestBody一致
	@RequestMapping("/provider/get/employee/feign")
	public Employee getEmployeeFeign();
	
	@RequestMapping("/provider/get/employee/hystrix")
	public ResultEntity<Employee> getEmployeeHystrix();
}
