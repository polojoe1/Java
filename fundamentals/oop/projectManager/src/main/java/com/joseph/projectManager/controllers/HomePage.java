package com.joseph.projectManager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.joseph.projectManager.models.Project;
import com.joseph.projectManager.models.User;
import com.joseph.projectManager.services.ProjectService;
import com.joseph.projectManager.services.UserService;

@Controller
public class HomePage {
	@Autowired
	private UserService userServ;

	@Autowired
	private ProjectService projectServ;

	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		} else {
			List<Project> allProjects = projectServ.allProjects();
			User thisUser = userServ.findOne(userId);
			model.addAttribute("thisUser", thisUser);
			model.addAttribute("allProjects", allProjects);
		}
		return "home.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

//	CREATE A NEW PROJECT SECTION

	@GetMapping("/projects/new")
	public String addProjectPage(@ModelAttribute("newProject") Project project, Model model, HttpSession session) {

		User thisUser = userServ.findOne((Long) session.getAttribute("user_id"));
		model.addAttribute("user", thisUser);
		return "addProject.jsp";
	}

	@PostMapping("/projects/add/new")
	public String addProjectHome(@Valid @ModelAttribute("newProject") Project project, BindingResult result,
			Model model, HttpSession session) {

		if (result.hasErrors()) {
			return "addProject.jsp";
		}

		else {
			User thisUser = userServ.findOne((Long) session.getAttribute("user_id"));
			thisUser.getProjects().add(project);
			projectServ.createProject(project);

			return "redirect:/home";
		}
	}

//	PROJECT INFO AND DETAILS

	@GetMapping("/projects/info/{id}")
	public String getProjectInfo(@PathVariable("id") Long id, Model model) {
		Project thisProject = projectServ.findProject(id);
		model.addAttribute("thisProject", thisProject);
		return "details.jsp";
	}

//	JOIN A PROJECT TEAM

	@GetMapping("/projects/join/{id}")
	public String joinProject(@PathVariable("id") Long id, HttpSession session) {
		User thisUser = userServ.findOne((Long) session.getAttribute("user_id"));
		Project thisProject = projectServ.findProject(id);
		thisUser.getProjects().add(thisProject);
		userServ.updateUser(thisUser);
		return "redirect:/home";
	}

//	LEAVE PROJECT TEAM

	@GetMapping("/projects/leave/{id}")
	public String leaveProject(@PathVariable("id") Long id, HttpSession session) {
		User thisUser = userServ.findOne((Long) session.getAttribute("user_id"));
		Project thisProject = projectServ.findProject(id);
		thisUser.getProjects().remove(thisProject);
		userServ.updateUser(thisUser);
		return "redirect:/home";
	}

//	EDIT PROJECT

	@GetMapping("/projects/edit/{id}")
	public String editProjectPage(@PathVariable("id") Long id,
			Model model,HttpSession s) {
		User thisUser = userServ.findOne((Long)s.getAttribute("user_id"));
		Project Myproject = projectServ.findProject(id);
		model.addAttribute("Myproject", Myproject);
		model.addAttribute("user", thisUser);
		return "editProject.jsp";
	}

	@PutMapping("/projects/edit/{id}")
	public String editPage(@Valid @ModelAttribute("Myproject")Project project, BindingResult result,@PathVariable("id") Long id, Model model) {
		if (result.hasErrors()) {
			return "editProject.jsp";
		} else {
			projectServ.updateProject(project);
			return "redirect:/home";
		}
	}
	
	
	
//	DELETE PROJECT
	@GetMapping("/projects/delete/{id}")
	public String deleteProjectNow(@PathVariable("id")Long id) {
		projectServ.deleteProject(id);
		return "redirect:/home";
	}
}
