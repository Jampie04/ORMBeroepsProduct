package repository;

import entity.Department;
import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeRepository {

    private EntityManager entityManager;

    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Employee> getEmployees() {
        String query = "select g from Employee g";
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query, Employee.class);
        return typedQuery.getResultList();
    }

    public Employee createEmployee(Employee employee) {
        try {
            if (!entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().begin();
            }
            Employee existingEmployee = findEmployeeByFullName(employee.getVoornaam(), employee.getAchternaam());
            if (existingEmployee != null) {
                existingEmployee.setId(employee.getId());
                entityManager.merge(existingEmployee);
                System.out.println("Employee already exist");
            } else {
                entityManager.persist(employee);
                System.out.println("Employee created: " + employee);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Could not create employee" + e);
            entityManager.getTransaction().rollback();
        }

        return employee;
    }

    public Employee findEmployeeByFullName(String voorNaam, String actherNaam) {
        String query = "SELECT e FROM Employee e WHERE e.voornaam = :voorNaam AND e.achternaam = :achterNaam";
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query, Employee.class);
        typedQuery.setParameter("voorNaam", voorNaam);
        typedQuery.setParameter("achterNaam", actherNaam);

        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Employee findEmployeeById(Long id) {
        String query = "SELECT e FROM Employee e WHERE e.id = :id";
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query, Employee.class);
        typedQuery.setParameter("id", id);

        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Employee updateSalary(Long id, BigDecimal salary) {
        Employee employee = findEmployeeById(id);
        entityManager.getTransaction().begin();
        employee.setSalary(salary);
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        return employee;
    }

    public Employee deleteEmployee(Long id) {
        Employee employee = findEmployeeById(id);
        try {
        entityManager.getTransaction().begin();
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Failed to delete Employee" + e);
        }
        return employee;
    }
}
