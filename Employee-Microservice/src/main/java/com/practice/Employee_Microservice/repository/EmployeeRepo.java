package com.practice.Employee_Microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.Employee_Microservice.model.Employee;

@Repository
public interface EmployeeRepo  extends JpaRepository<Employee, Integer>{

	public List<Employee> findByProjectCode(int pCode);
}
