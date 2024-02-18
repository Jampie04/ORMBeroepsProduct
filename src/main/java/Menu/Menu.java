package Menu;

import dto.CreateEmployeeDto;
import entity.Department;
import entity.Employee;
import entity.Project;
import service.DepartmentService;
import service.EmployeeService;
import service.ProjectService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void showMenu(){
        System.out.println("""
            (1) Registreer nieuwe employee
            (2) Show All Employees
            (3) Create Dept
            (4) Show All Dept
            (5) Find Employee By Id
            (6) Find Department By Id
            (7) Find Department By Name
            (8) Update employee salary
            (9) Delete employee
            (10) Create project
            
            (99) Exit
        """);
    }

    public static void menuInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Menu option> ");
        String menuOption = scanner.nextLine();

        switch (menuOption) {
            case "2" -> Menu.showAllEmployees();
            case "3" -> Menu.createDepartment();
            case "4" -> Menu.showAllDept();
            case "5" -> Menu.findEmployeeByFullName();
            case "6" -> Menu.findDepartmentById();
            case "7" -> Menu.findDepartmentByName();
            case "8" -> Menu.updateEmployeeSalary(102L, BigDecimal.valueOf(14000));
            case "9" -> Menu.deleteEmployee(2L);
            case "10" -> Menu.createProject();
            case "99" -> System.exit(0);
        }
    }

    private static void createProject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Project name: ");
        String projectName = scanner.nextLine();
        ProjectService projectService = new ProjectService();
        Project project = new Project();
        project.setProjectname(projectName);
        projectService.createProject(project);
    }

    private static void deleteEmployee(Long id) {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = employeeService.deleteEmployee(id);
    }

    private static void updateEmployeeSalary(Long id, BigDecimal salary) {
        EmployeeService employeeService = new EmployeeService();
        Employee employee = employeeService.updateSalary(id, salary);
        System.out.println(employee);
    }
    public static void showAllEmployees(){
        EmployeeService employeeService = new EmployeeService();
        for(Employee employee : employeeService.getEmployees()){
            System.out.println(employee);
        }
    }
    public static void showAllDept(){
        DepartmentService departmentService = new DepartmentService();
        for(Department department : departmentService.getDepartment()){
            System.out.println(department);
        }
    }
    public static void findEmployeeByFullName(){
        EmployeeService employeeService = new EmployeeService();
        Employee employee = employeeService.findEmployee("Jamil", "Nasio");
        System.out.println(employee);

    }
    public static void findDepartmentById(){
        DepartmentService departmentService = new DepartmentService();
        Department department = departmentService.findDepartmentByName("ICT");
        System.out.println(department);

    }
    public static void findDepartmentByName(){
        DepartmentService departmentService = new DepartmentService();
        Department department = departmentService.findDepartmentByName("ICT");
        System.out.println(department);

    }
    public static void createDepartment(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Department: ");
        String departmentName = scanner.nextLine();
        DepartmentService departmentService = new DepartmentService();
        Department department = new Department();
        department.setDeptname(departmentName);
        departmentService.createDepartment(department);

    }
}
