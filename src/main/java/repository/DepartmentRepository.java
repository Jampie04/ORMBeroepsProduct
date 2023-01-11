package repository;

import entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DepartmentRepository {

    private EntityManager entityManager;

    public DepartmentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Department> getDepartment() {
        String query = "select g from Employee g";
        TypedQuery<Department> typedQuery = entityManager.createQuery(query, Department.class);
        List<Department> employeeList = typedQuery.getResultList();
        return employeeList;
    }

    public Department createDepartment(Department department){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(department);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return department;
    }
}
