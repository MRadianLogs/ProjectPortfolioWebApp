package com.reyesProjects.ProjectPortfolio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectPortfolioWebAppApplication {

	private static final Logger log = LoggerFactory.getLogger(ProjectPortfolioWebAppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectPortfolioWebAppApplication.class, args);
	}

	@Bean
	  public CommandLineRunner demo(ProjectController projects) {
	    return (args) -> {
	      // save a few customers
	      projects.createNewProject("Autocreated test project 1");
	      projects.createNewProject("Autocreated test project 2");
	      projects.createNewProject("Autocreated test project 3");
	      projects.createNewProject("ATP 4");
	      
	      
	      // Get all projects
	      log.info("All Projects:");
	      log.info("-------------------------------");
	      for (Project project : projects.getAllProjects()) {
	        log.info(project.toString());
	      }
	      log.info("");

	      // Get project by Id.
	      Project idProject = projects.getProject(1); //TODO: Test 0.
	      log.info("Project with id 0:");
	      log.info("--------------------------------");
	      log.info(idProject.toString());
	      log.info("");
	      
	      // Get project by name.
	      Project nameProject = projects.getProject("Autocreated test project 2");
	      log.info("Project with name Autocreated test project 2:");
	      log.info("--------------------------------");
	      log.info(nameProject.toString());
	      log.info("");

	      //TODO: Test multiple projects with same name.
	      log.info("");
	    };
	}
}
