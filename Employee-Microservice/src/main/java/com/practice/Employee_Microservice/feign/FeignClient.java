package com.practice.Employee_Microservice.feign;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.practice.Employee_Microservice.model.Project;

@org.springframework.cloud.openfeign.FeignClient(url = "http://localhost:8085", value="project-microservice", path = "/api/pro")
public interface FeignClient {
	
	@GetMapping("project/{pCode}")
//	feign.Response getProjectByCode(@PathVariable int pCode);
	Project getProjectByCode(@PathVariable int pCode);

	
	

}
