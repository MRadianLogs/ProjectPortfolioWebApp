package com.reyesProjects.ProjectPortfolio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ProjectPortfolioWebAppApplication {

	private static final Logger log = LoggerFactory.getLogger(ProjectPortfolioWebAppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectPortfolioWebAppApplication.class, args);
	}

	@Bean
	  public CommandLineRunner demo(ProjectController projects) {
	    return (args) -> 
	    {
	    	log.info("");
	    	log.info("vvvvvvvvvvvvvvvv Database Tests vvvvvvvvvvvvvvvvvvvvvv");
	    	
	    	// save a few customers
	    	String testProject1 = "Autocreated test project 1";
	    	String testProject2 = "Autocreated test project 2";
	    	String testProject3 = "Autocreated test project 3";
	    	String testProject4 = "ATP 4";
	    	if(projects.getProject(testProject1) == null)
	    		projects.createNewProject(testProject1);
	    	if(projects.getProject(testProject2) == null)
	    		projects.createNewProject(testProject2);
	    	if(projects.getProject(testProject3) == null)
	    		projects.createNewProject(testProject3);
	    	if(projects.getProject(testProject4) == null)
	    		projects.createNewProject(testProject4);	      
	      
	      // Get all projects
	      log.info("All Projects:");
	      log.info("-------------------------------");
	      for (Project project : projects.getAllProjects()) {
	        log.info(project.toString());
	      }
	      log.info("");

	      // Get project by Id.
	      Project idProject = projects.getProject(1); //TODO: Test 0.
	      if(idProject!=null)
	      {
	    	  log.info("Project with id 0:");
	    	  log.info("--------------------------------");
	    	  log.info(idProject.toString());
	    	  log.info("");
	      }
	      
	      // Get project by name.
	      String nameToSearch = "ATP 4";
	      Project nameProject = projects.getProject(nameToSearch);
	      if(nameProject != null)
	      {
	    	log.info("Project with name " + nameToSearch + ": ");
	      	log.info("--------------------------------");
	      	log.info(nameProject.toString());
	      	log.info("");
	      }
	      
	      //TODO: Test multiple projects with same name.
	      log.info("");
	    };
	}
}
