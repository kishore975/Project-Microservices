package com.practice.Project_Microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.Project_Microservice.model.Project;
import com.practice.Project_Microservice.service.ProjectService;

@RestController
@RequestMapping("/api/pro")
public class ProjectController {
	
	@Autowired
	ProjectService projectService; 
	
	@GetMapping("/test")
	public ResponseEntity<String> doTest(){
		return new ResponseEntity<String>("ProjectMicroserviceApplication is Good.!", HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Project> addProject(@RequestBody Project project){
		return new ResponseEntity<Project>(projectService.addProject(project), HttpStatus.CREATED);
	}
	
	@GetMapping("project/{pCode}")
	public ResponseEntity<Project> getProjectByCode(@PathVariable int pCode){
		return new ResponseEntity<Project>(projectService.getProjectByCode(pCode), HttpStatus.OK);
	}

}
