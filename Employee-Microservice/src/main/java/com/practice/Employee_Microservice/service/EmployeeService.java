package com.practice.Employee_Microservice.service;

import java.util.List;

import com.practice.Employee_Microservice.model.Employee;
import com.practice.Employee_Microservice.payload.EmployeePayload;

public interface EmployeeService {
	
	public EmployeePayload addEmployee(Employee employee);
	
	public EmployeePayload getEmployeeByEmpId(int employeeId);
	
	public List<EmployeePayload> getEmployeesByProjectCode(int projectCode);

}
