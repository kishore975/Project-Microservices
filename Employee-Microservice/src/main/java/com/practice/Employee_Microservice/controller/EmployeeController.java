package com.practice.Employee_Microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.Employee_Microservice.model.Employee;
import com.practice.Employee_Microservice.payload.EmployeePayload;
import com.practice.Employee_Microservice.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/test")
	public ResponseEntity<String> doTest() {
		return new ResponseEntity<String>("EmployeeMicroserviceApplication is Good.!",HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<EmployeePayload> addEmployee(@RequestBody Employee emp){
		return new ResponseEntity<EmployeePayload>(employeeService.addEmployee(emp),HttpStatus.CREATED);
	}
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<EmployeePayload> getEmployeeByEmpId(@PathVariable int empId){
		return new ResponseEntity<EmployeePayload>(employeeService.getEmployeeByEmpId(empId), HttpStatus.OK);
	}
	
	@GetMapping("employees/{proCode}")
	public ResponseEntity<List<EmployeePayload>> getEmployeesByProCode(@PathVariable int proCode){
		return new ResponseEntity<List<EmployeePayload>>(employeeService.getEmployeesByProjectCode(proCode), HttpStatus.OK);
	}
	

}
