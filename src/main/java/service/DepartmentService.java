package service;

import configuration.JPAConfiguration;
import entity.Department;
import repository.DepartmentRepository;

import java.util.List;

public class DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentService() {
        this.repository = new DepartmentRepository(JPAConfiguration.getEntityManager());
    }

    public List<Department> getDepartment() {
        return repository.getDepartment();
    }

    public Department findDepartmentById(Long id) {
        return repository.findDepartmentById(id);
    }
    public Department findDepartmentByName(String deptName) {
        return repository.findDepartmentByName(deptName);
    }

    public Department createDepartment(Department department) {
        return repository.createDepartment(department);
    }
}
