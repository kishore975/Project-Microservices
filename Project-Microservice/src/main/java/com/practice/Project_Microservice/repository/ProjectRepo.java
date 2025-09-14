package com.practice.Project_Microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.Project_Microservice.model.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer>{
	
	

}
