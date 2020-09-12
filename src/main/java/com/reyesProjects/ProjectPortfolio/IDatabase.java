package com.reyesProjects.ProjectPortfolio;

import java.util.List;

public interface IDatabase 
{
	public List<Project> getAllProjects();
	
	public Project getProject(int projectId);
	
	public Project getProject(String projectName);
	
	public Project addNewProjectToDatabase(Project newProject);
	
	public Project updateAllProjectDetails(int projectId, String newProjectName, String newProjectDescription, String newGithubLink);
	
	public Project updateProjectName(int projectId, String newProjectName);
	
	public Project updateProjectDescription(int projectId, String newProjectDescription);
	
	public Project updateProjectGithubLink(int projectId, String newGithubLink);
	
	public void deleteProjectFromDatabase(int projectId);
}
