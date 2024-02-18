package repository;

import entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DepartmentRepository {

    private EntityManager entityManager;

    public DepartmentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Department> getDepartment() {
        String query = "select g from Department g";
        TypedQuery<Department> typedQuery = entityManager.createQuery(query, Department.class);
        return typedQuery.getResultList();
    }

    public Department findDepartmentById(Long id) {
        String query = "SELECT d FROM Department d WHERE d.id = :id";
        TypedQuery<Department> typedQuery = entityManager.createQuery(query, Department.class);
        typedQuery.setParameter("id", id);

        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Department findDepartmentByName(String deptName) {
        String query = "SELECT d FROM Department d WHERE d.deptname = :deptName";
        TypedQuery<Department> typedQuery = entityManager.createQuery(query, Department.class);
        typedQuery.setParameter("deptName", deptName);

        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Department createDepartment(Department department) {
        try {
            entityManager.getTransaction().begin();
            Department existingDepartment = findDepartmentByName(department.getDeptname());
            if (existingDepartment != null) {
                existingDepartment.setDeptname(department.getDeptname());
                entityManager.merge(existingDepartment);
                System.out.println("Department already exist");
            } else {
                entityManager.persist(department);
                System.out.println("Department created: " + department.getDeptname());
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Could not create department" + e);
            entityManager.getTransaction().rollback();
        }

        return department;
    }
}
