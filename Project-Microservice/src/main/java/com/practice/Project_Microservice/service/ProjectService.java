package com.practice.Project_Microservice.service;

import com.practice.Project_Microservice.model.Project;

public interface ProjectService {
	
	public Project addProject(Project project);
	
	public Project getProjectByCode(int pCode);

}
