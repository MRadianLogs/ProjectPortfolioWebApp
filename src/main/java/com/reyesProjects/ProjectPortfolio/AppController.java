package com.reyesProjects.ProjectPortfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController 
{
	@Autowired
	ProjectRepository projectDatabase;
	ProjectController projectController = new ProjectController(projectDatabase);
	
	@GetMapping("/home")
	public String ShowHomePage()
	{
		return "homePage";
	}
	
	@GetMapping("/home/projects")
	public String ShowAllProjectsPage(Model model)
	{
		model.addAllAttributes(projectController.getAllProjects()); //TODO: Find out how to access all of these guys in thymeleaf.
		return "allProjectsPage";
	}
	
	@GetMapping("/home/projects/project")
	public String ShowSpecificProjectPage(@RequestParam(name = "projectnum", required=true) int projectNum, Model model)
	{
		model.addAttribute("projectNum", projectController.getProject(projectNum));
		return "specificProjectPage";
	}
}
