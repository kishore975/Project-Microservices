package com.practice.Employee_Microservice.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.practice.Employee_Microservice.feign.FeignClient;
import com.practice.Employee_Microservice.model.Employee;
import com.practice.Employee_Microservice.model.Project;
import com.practice.Employee_Microservice.payload.EmployeePayload;
import com.practice.Employee_Microservice.repository.EmployeeRepo;
import com.practice.Employee_Microservice.service.EmployeeService;

import feign.Response;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	FeignClient feignClient;

	@Override
	public EmployeePayload addEmployee(Employee employee) {
		Employee savedEmp= employeeRepo.save(employee);
//		Response response= feignClient.getProjectByCode(savedEmp.getProjectCode());
//		String body=response.body().toString();
//		Gson gson= new Gson();
//		Project pro=gson.fromJson(body, Project.class);
		Project pro=feignClient.getProjectByCode(savedEmp.getProjectCode());
		
		EmployeePayload empPayload= new EmployeePayload();
		empPayload.setEmpId(savedEmp.getEmpId());
		empPayload.setEmpName(savedEmp.getEmpName());
		empPayload.setEmpEmail(savedEmp.getEmpEmail());
		empPayload.setEmpSalary(savedEmp.getEmpSalary());
		empPayload.setProjectCode(savedEmp.getProjectCode());
		empPayload.setProjectName(pro.getProjectName());
		return empPayload;
	}

	@Override
	public EmployeePayload getEmployeeByEmpId(int employeeId) {
		Employee emp=employeeRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("No Employee found with ID : "+employeeId));
//		Response response= feignClient.getProjectByCode(emp.getProjectCode());
//		String body=response.body().toString();
//		Gson gson= new Gson();
//		Project pro=gson.fromJson(body, Project.class);
		Project pro=feignClient.getProjectByCode(emp.getProjectCode());
		
		EmployeePayload empPayload= new EmployeePayload();
		empPayload.setEmpId(emp.getEmpId());
		empPayload.setEmpName(emp.getEmpName());
		empPayload.setEmpEmail(emp.getEmpEmail());
		empPayload.setEmpSalary(emp.getEmpSalary());
		empPayload.setProjectCode(emp.getProjectCode());
		empPayload.setProjectName(pro.getProjectName());
		return empPayload;
	}

	@Override
	public List<EmployeePayload> getEmployeesByProjectCode(int projectCode) {
//		Response response= feignClient.getProjectByCode(projectCode);
//		String body=response.body().toString();
//		Gson gson= new Gson();
//		Project pro=gson.fromJson(body, Project.class);
		Project pro=feignClient.getProjectByCode(projectCode);
		
		List<Employee> employees= employeeRepo.findByProjectCode(projectCode);
		

		List<EmployeePayload> list= new ArrayList<>();
		for(Employee emp: employees) {
			EmployeePayload payLoad= new EmployeePayload();
			payLoad.setEmpId(emp.getEmpId());
			payLoad.setEmpName(emp.getEmpName());
			payLoad.setEmpEmail(emp.getEmpEmail());
			payLoad.setEmpSalary(emp.getEmpSalary());
			payLoad.setProjectCode(emp.getProjectCode());
			payLoad.setProjectName(pro.getProjectName());
			list.add(payLoad);
		}
		return list;
	}


}
