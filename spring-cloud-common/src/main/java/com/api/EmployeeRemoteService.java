package com.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Employee;

@FeignClient("provider") //provider��΢�������ƣ���·��Ҫ��autowrite�İ�·��һ��
public interface EmployeeRemoteService {
	
	//Զ�̵��õĽӿڷ�����
	//Ҫ��@RequestMappingע��ӳ��ĵ�ַһ�£�
	//Ҫ�󷽷�����һ��,
	//Ҫ��@RequestParam��@PathVariable��@RequestBodyһ��
	@RequestMapping("/provider/get/employee/feign")
	public Employee getEmployeeFeign();
}
