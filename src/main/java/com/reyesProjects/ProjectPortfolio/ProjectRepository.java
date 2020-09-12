package com.reyesProjects.ProjectPortfolio;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer>, IDatabase 
{
	public default List<Project> getAllProjects()
	{
		return findAll();
	}
	
	public default Project getProject(int projectId)
	{
		return findById(projectId);
	}
	
	public default Project getProject(String projectName)
	{
		return findByName(projectName);
	}
	
	public default Project saveProjectInDatabase(Project projectInstance)
	{
		Project savedProject = this.save(projectInstance); 
		if(savedProject != null)
		{
			return savedProject; //Saving was successful.
		}
		else
			return null; //Saving failed.
	}
	
	public default Project addNewProjectToDatabase(Project newProject)
	{
		return saveProjectInDatabase(newProject);
	}
	
	public default Project updateAllProjectDetails(int projectId, String newProjectName, String newProjectDescription, String newGithubLink)
	{
		Project projectToUpdate = getProject(projectId);
		if(projectToUpdate != null)
		{ //TODO: Consider changing the POJO project code to allow chaining of methods.
			projectToUpdate.setName(newProjectName);
			projectToUpdate.setDescription(newProjectDescription);
			projectToUpdate.setGithubLink(newGithubLink);
			
			return saveProjectInDatabase(projectToUpdate);
		}
		else
			return null; //Failed to find project in database with that id.
	}
	
	public default Project updateProjectName(int projectId, String newProjectName)
	{
		Project projectToUpdate = getProject(projectId);
		if(projectToUpdate != null)
		{ 
			projectToUpdate.setName(newProjectName);
			
			return saveProjectInDatabase(projectToUpdate);
		}
		else
			return null; //Failed to find project in database with that id.
	}
	
	public default Project updateProjectDescription(int projectId, String newProjectDescription)
	{
		Project projectToUpdate = getProject(projectId);
		if(projectToUpdate != null)
		{ 
			projectToUpdate.setDescription(newProjectDescription);
			
			return saveProjectInDatabase(projectToUpdate);
		}
		else
			return null; //Failed to find project in database with that id.
	}
	
	public default Project updateProjectGithubLink(int projectId, String newGithubLink) 
	{
		Project projectToUpdate = getProject(projectId);
		if(projectToUpdate != null)
		{ 
			projectToUpdate.setGithubLink(newGithubLink);
			
			return saveProjectInDatabase(projectToUpdate);
		}
		else
			return null; //Failed to find project in database with that id.
	}
	
	public default void deleteProjectFromDatabase(int projectId)
	{
		this.deleteById(projectId);
	}

	//Methods for accessing data via JPA.
	
	public Project findByName(String projectName); //TODO: Consider what happens when two projects have the same name!
	
	public Project findById(int id);
	
	public List<Project> findAll();
}
