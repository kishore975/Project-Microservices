package com.practice.Employee_Microservice.payload;

public class EmployeePayload {
	
	private int empId;
	private String empName;
	private String empEmail;
	private double empSalary;
	private int projectCode;
	private String projectName;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public int getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	@Override
	public String toString() {
		return "EmployeePayload [empId=" + empId + ", empName=" + empName + ", empEmail=" + empEmail + ", empSalary="
				+ empSalary + ", projectCode=" + projectCode + ", projectName=" + projectName + "]";
	}
	
	
	

}
