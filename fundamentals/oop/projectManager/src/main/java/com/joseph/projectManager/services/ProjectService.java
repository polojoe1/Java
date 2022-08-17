package com.joseph.projectManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseph.projectManager.models.Project;
import com.joseph.projectManager.repositories.ProjectRepository;
@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> allProjects(){
		return projectRepository.findAll();
	}
	
	public Project createProject(Project newProject) {
		return projectRepository.save(newProject);
	}
	
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}
	
	public void deleteProject(Long id) {
		projectRepository.deleteById(id);
	}
	
	public Project findProject(Long id) {
		Optional<Project> optionalProject = projectRepository.findById(id);
		if (optionalProject.isPresent()) {
			return optionalProject.get();
		} else {
			return null;
		}
	}
}
