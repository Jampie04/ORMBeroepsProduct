package repository;

import entity.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProjectRepository {

    private EntityManager entityManager;

    public ProjectRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Project> getProject() {
        String query = "select g from Project g";
        TypedQuery<Project> typedQuery = entityManager.createQuery(query, Project.class);
        List<Project> projectList = typedQuery.getResultList();
        return projectList;
    }

    public Project createProject(Project project){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(project);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return project;
    }
}