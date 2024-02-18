package repository;

import entity.Department;
import entity.Employee;
import entity.Project;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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

    public Project createProject(Project project) {
        try {
            entityManager.getTransaction().begin();
            Project existingEmployee = findProjectByName(project.getProjectname());
            if (existingEmployee != null) {
                existingEmployee.setProjectname(project.getProjectname());
                entityManager.merge(existingEmployee);
                System.out.println("Project already exist");
            } else {
                entityManager.persist(project);
                System.out.println("Project created: " + project);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Could not create project" + e);
            entityManager.getTransaction().rollback();
        }

        return project;
    }

    public Project findProjectById(Long id) {
        String query = "SELECT p FROM Project p WHERE p.id = :id";
        TypedQuery<Project> typedQuery = entityManager.createQuery(query, Project.class);
        typedQuery.setParameter("id", id);

        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    private Project findProjectByName(String projectName) {
        String query = "SELECT p FROM Project p WHERE p.projectname = :projectname";
        TypedQuery<Project> typedQuery = entityManager.createQuery(query, Project.class);
        typedQuery.setParameter("projectname", projectName);

        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}