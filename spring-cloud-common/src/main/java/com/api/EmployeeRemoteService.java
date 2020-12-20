package com.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Employee;
import com.factory.MyFallBackFactory;
import com.util.ResultEntity;

//provider��΢�������ƣ���·��Ҫ��autowrite�İ�·��һ��
//fallbackFactoryָ��provider�������ǵı�ѡ������Hystrix������
@FeignClient(value = "provider" , fallbackFactory = MyFallBackFactory.class) 
public interface EmployeeRemoteService {
	
	//Զ�̵��õĽӿڷ�����
	//Ҫ��@RequestMappingע��ӳ��ĵ�ַһ�£�
	//Ҫ�󷽷�����һ��,
	//Ҫ��@RequestParam��@PathVariable��@RequestBodyһ��
	@RequestMapping("/provider/get/employee/feign")
	public Employee getEmployeeFeign();
	
	@RequestMapping("/provider/get/employee/hystrix")
	public ResultEntity<Employee> getEmployeeHystrix();
}
