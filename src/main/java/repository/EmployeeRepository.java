package repository;

import entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaUpdate;

import java.util.List;

public class EmployeeRepository {

    private EntityManager entityManager;



    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //Alle records ophalen
    public List<Employee> getEmployees() {
        String query = "select g from Employee g";
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query, Employee.class);
        List<Employee> employeeList = typedQuery.getResultList();
        return employeeList;
    }


    public Employee createEmployee(Employee employee){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return employee;
    }


    public Employee findEmployee(long id ){
        Employee employee = entityManager.find(Employee.class, id);
        if (employee == null ){
            System.out.println("Not Found");
            return null;
        }
        return employee;
    }

    public Employee updateSalary(long id, Integer salary){
       Employee employee = findEmployee(id);
       entityManager.getTransaction().begin();
       employee.setSalary(salary);
       entityManager.persist(employee);
       entityManager.getTransaction().commit();
       return employee;
    }

    public void deleteEmployee(long id){
        Employee employee = findEmployee(id);
        entityManager.getTransaction().begin();
        entityManager.remove(employee);
        entityManager.getTransaction().commit();
    }




}
