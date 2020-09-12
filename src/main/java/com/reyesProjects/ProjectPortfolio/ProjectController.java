package com.reyesProjects.ProjectPortfolio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectController 
{
	
	IDatabase projectDatabase;
	
	@Autowired
	public ProjectController(IDatabase databaseType)
	{
		projectDatabase = databaseType;
	}
	
	public List<Project> getAllProjects()
	{
		return projectDatabase.getAllProjects();
	}
	
	public Project getProject(int projectId)
	{
		return projectDatabase.getProject(projectId);
	}
	
	public Project getProject(String projectName)
	{
		return projectDatabase.getProject(projectName);
	}
	
	public Project createNewProject(String newProjectName)
	{
		//Create new project.
		Project newProject = new Project(newProjectName);
		
		//Store in database and return.
		return projectDatabase.addNewProjectToDatabase(newProject);
	}
	
	public Project updateAllProjectDetails(int projectId, String newProjectName, String newProjectDescription, String newGithubLink)
	{
		return projectDatabase.updateAllProjectDetails(projectId, newProjectName, newProjectDescription, newGithubLink);
	}
	
	public Project updateProjectName(int projectId, String newProjectName)
	{
		return projectDatabase.updateProjectName(projectId, newProjectName);
	}
	
	public Project updateProjectDescription(int projectId, String newProjectDescription)
	{
		return projectDatabase.updateProjectDescription(projectId, newProjectDescription);
	}
	
	public Project updateProjectGithubLink(int projectId, String newGithubLink)
	{
		return projectDatabase.updateProjectGithubLink(projectId, newGithubLink);
	}
	
	public void deleteProject(int projectId)
	{
		projectDatabase.deleteProjectFromDatabase(projectId);
	}
}
