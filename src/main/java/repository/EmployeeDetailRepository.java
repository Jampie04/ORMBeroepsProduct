package repository;

import entity.EmployeeDetail;
import entity.Employee;
import jakarta.persistence.EntityManager;

public class EmployeeDetailRepository {

    private EntityManager entityManager;

    public EmployeeDetailRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EmployeeDetail createEmployeeDetail(EmployeeDetail employeeDetail) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employeeDetail);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employeeDetail;
    }
}
