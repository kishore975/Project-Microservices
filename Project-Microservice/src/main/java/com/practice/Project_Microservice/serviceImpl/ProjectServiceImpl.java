package com.practice.Project_Microservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.Project_Microservice.model.Project;
import com.practice.Project_Microservice.repository.ProjectRepo;
import com.practice.Project_Microservice.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectRepo projectRepo;

	@Override
	public Project addProject(Project project) {
		return projectRepo.save(project);
	}

	@Override
	public Project getProjectByCode(int pCode) {
		return projectRepo.findById(pCode).orElseThrow(()-> new RuntimeException("No Project found with code : "+pCode));
	}



}
