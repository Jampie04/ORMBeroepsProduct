package service;

import configuration.JPAConfiguration;
import dto.CreateEmployeeDto;
import entity.Department;
import entity.Employee;
import entity.EmployeeDetail;
import entity.Project;
import repository.DepartmentRepository;
import repository.EmployeeRepository;
import repository.ProjectRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;
    private final ProjectService projectService;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository(JPAConfiguration.getEntityManager());
        this.departmentService = new DepartmentService();
        this.projectService = new ProjectService();
    }

    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    public CreateEmployeeDto createEmployee(CreateEmployeeDto createEmployeeDto) {
        //Create employee detail
        EmployeeDetailService employeeDetailService = new EmployeeDetailService();
        EmployeeDetail employeeDetail = new EmployeeDetail();
        employeeDetail.setAdress(createEmployeeDto.getAdress());
        employeeDetail.setTelefoonNummer(createEmployeeDto.getTelefoonNummer());
        employeeDetail.setBankNaam(createEmployeeDto.getBankNaam());
        EmployeeDetail detail = employeeDetailService.createEmployeeDetail(employeeDetail);

        //Create employee
        Employee employee = new Employee();
        employee.setVoornaam(createEmployeeDto.getVoornaam());
        employee.setAchternaam(createEmployeeDto.getAchternaam());
        employee.setSalary(createEmployeeDto.getSalary());
        employee.setManagerId(createEmployeeDto.getManagerId());
        employee.setEmployeeDetailId(detail);

        //Get department
        Department department = departmentService.findDepartmentById(createEmployeeDto.getDepartmentId());
        employee.setDepartment(department);
        //Get project

        List<Project> projectList = new ArrayList<>();
        for(Project projects : createEmployeeDto.getProjects()) {
            Project project = projectService.findProjectById(projects.getId());
            projectList.add(project);
            employee.setProject(projectList);
        }
        employeeRepository.createEmployee(employee);
        return CreateEmployeeDto.builder()
                .voornaam(createEmployeeDto.getVoornaam())
                .achternaam(createEmployeeDto.getAchternaam())
                .departmentId(createEmployeeDto.getDepartmentId())
                .projects(createEmployeeDto.getProjects())
                .build();
    }

    public Employee updateSalary(Long id, BigDecimal salary) {
        return employeeRepository.updateSalary(id, salary);
    }

    public Employee deleteEmployee(Long id) {
        return employeeRepository.deleteEmployee(id);
    }

    public Employee findEmployee(String voorNaam, String achterNaam) {
        return employeeRepository.findEmployeeByFullName(voorNaam, achterNaam);
    }
}
