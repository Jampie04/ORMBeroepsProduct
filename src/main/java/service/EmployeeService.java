package service;

import configuration.JPAConfiguration;
import entity.Employee;
import repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService() {
        this.repository = new EmployeeRepository(JPAConfiguration.getEntityManager());
    }

    public List<Employee> getEmployees() {
        return repository.getEmployees();
    }

    public Employee createEmployee(Employee employee) {
        return repository.createEmployee(employee);
    }

    public Employee updateSalary(Long id, Integer salary) {
        return repository.updateSalary(id, salary);
    }

    public void deleteEmployee(Long id) {
        repository.deleteEmployee(id);
    }

    public Employee findEmployee(Long id) {
        return repository.findEmployee(id);
    }
}
