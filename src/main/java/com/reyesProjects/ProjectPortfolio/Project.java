package com.reyesProjects.ProjectPortfolio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private String githubLink;
	
	public Project() {}
	
	public Project(String newProjectName)
	{
		this.name = newProjectName;
	}

	public int getId() 
	{
		return id;
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
	
	@Override
	public String toString()
	{
		return String.format("Project: %d, Name: %s, Description: %s, GithubLink: %s", id, name, description, githubLink);
	}
}
