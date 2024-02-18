package service;

import configuration.JPAConfiguration;
import entity.Project;
import repository.ProjectRepository;

import java.util.List;

public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService() {
        this.repository = new ProjectRepository(JPAConfiguration.getEntityManager());
    }

    public List<Project> getProject() {
        return repository.getProject();
    }

    public Project findProjectById(Long id){return repository.findProjectById(id);}

    public Project createProject(Project project) {
        return repository.createProject(project);
    }
}