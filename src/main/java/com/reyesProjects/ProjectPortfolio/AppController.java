package com.reyesProjects.ProjectPortfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController
{
	@Autowired
	private ProjectRepository projectDatabase;
	
	@Autowired
	private ProjectController projectController;// = new ProjectController(projectDatabase);
	
	@GetMapping("/home")
	public String ShowHomePage()
	{
		//return "homePage";
		return "index";
	}
	
	@GetMapping("/home/projects")
	public String ShowAllProjectsPage(Model model)
	{
		model.addAttribute( "projectsList", projectController.getAllProjects()); //TODO: Find out how to access all of these guys in thymeleaf.
		return "allProjectsPage";
	}
	
	@GetMapping("/home/projects/project")
	public String ShowSpecificProjectPage(@RequestParam(name = "projectNum", required=true) int projectNum, Model model)
	{
		model.addAttribute("project", projectController.getProject(projectNum));
		return "specificProjectPage";
	}
	
	@GetMapping("/home/projects/newproject")
	public String ShowCreateNewProjectFormPage(Model model)
	{
		model.addAttribute("newproject", new Project());
		return "newProjectFormPage";
	}
	@PostMapping("/home/projects/newproject")
	public String SubmitCreateNewProjectForm(@ModelAttribute Project newProject, Model model)
	{
		projectController.createNewProject(newProject);
		model.addAttribute("project", newProject);
		return "specificProjectPage";
	}
}
