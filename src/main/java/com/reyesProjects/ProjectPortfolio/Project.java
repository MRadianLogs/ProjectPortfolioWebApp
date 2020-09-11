package com.reyesProjects.ProjectPortfolio;

public class Project 
{
	private int ID;
	private String name;
	private String description;
	private String githubLink;
	
	public Project() {}
	
	public Project(String newProjectName)
	{
		this.name = newProjectName;
	}

	public int getID() 
	{
			return ID;
	}
	
	public String getName() 
	{
		return name;
	}
	public void setName(String newProjectName) 
	{
		this.name = newProjectName;
	}

	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String newProjectDescription) 
	{
		this.description = newProjectDescription;
	}

	public String getGithubLink() 
	{
		return githubLink;
	}
	public void setGithubLink(String newGithubLink) 
	{
		this.githubLink = newGithubLink;
	}
}
