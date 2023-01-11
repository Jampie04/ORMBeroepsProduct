package Menu;

import Request.DirectorRequest;
import Request.HRRequest;
import Request.ManagerRequest;
import Request.RequestType;
import entity.Department;
import entity.Employee;
import entity.EmployeeDetail;
import entity.Project;
import service.DepartmentService;
import service.EmployeeDetailService;
import service.EmployeeService;
import Request.DirectorRequest;
import Request.HRRequest;
import Request.ManagerRequest;
import Request.Request;
import service.ProjectService;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    public static void showMenu(){
        System.out.println("""
            (1) Registreer nieuwe employee
            (2) Show All Employees
            
            (99) Exit
        """);
    }

    public static void menuInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Menu option> ");
        String menuOption = scanner.nextLine();

        switch (menuOption) {
            case "1" -> Menu.registreerScherm();
            case "2" -> Menu.showAllEmployees();
            case "99" -> System.exit(0);
        }
    }

    public static void showAllEmployees(){
        EmployeeService employeeService = new EmployeeService();
        for(Employee employee : employeeService.getEmployees()){
            System.out.println(employee);

        }

    }

    public static void registreerScherm(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Voornaam: ");
        String voornaam = scanner.nextLine();
        System.out.print("Achternaam: ");
        String achternaam = scanner.nextLine();
        System.out.print("Salary: ");
        String salary = scanner.nextLine();
        System.out.print("Department: ");
        String departmentName = scanner.nextLine();
        System.out.print("Project: ");
        String project = scanner.nextLine();
        System.out.print("Banknaam: ");
        String banknaam = scanner.nextLine();
        System.out.print("Adres: ");
        String adress = scanner.nextLine();
        System.out.print("Telefoonnummer: ");
        String telefoonnummer = scanner.nextLine();
        System.out.print("Manager: ");
        String manager = scanner.nextLine();





        EmployeeDetailService employeeDetailService = new EmployeeDetailService();
        EmployeeService employeeService = new EmployeeService();

        DepartmentService departmentService = new DepartmentService();
        Department department = new Department();
        department.setDeptname(departmentName);
        departmentService.createDepartment(department);

        EmployeeDetail employeeDetail = new EmployeeDetail();
        employeeDetail.setAdress(adress);
        employeeDetail.setBankNaam(banknaam);
        employeeDetail.setTelefoonNummer(telefoonnummer);

        EmployeeDetail detail1 = employeeDetailService.createEmployeeDetail(employeeDetail);

        Employee createEmployee = new Employee();
        Project project1 = new Project();
        ProjectService projectService = new ProjectService();

        createEmployee.setVoornaam(voornaam);
        createEmployee.setAchternaam(achternaam);
        createEmployee.setSalary(Integer.valueOf(salary));
        createEmployee.setEmployeeDetail(detail1);
        createEmployee.setDepartment(department);
        createEmployee.setManagerId(Long.valueOf(manager));

        Set<Project> projectSet = new HashSet<Project>();
        Project project2 = new Project();
        project2.setProjectname(project);

//        projectSet.add(new Project)

        projectSet.add(project2);


//        Project project3 = projectService.createProject(project2);
//        projectSet.add(project3);

        createEmployee.setProject(projectSet);
        employeeService.createEmployee(createEmployee);
        System.out.println("Succesvol gecreeerd!:  " + createEmployee.getVoornaam());

//        project1.setProjectname(project);
//        Set<Employee> employeeSet = new HashSet<>();
//        employeeSet.add(createEmployee);
//        project1.setEmployees(employeeSet);
//        projectService.createProject(project1);

        HRRequest directorRequest = new DirectorRequest();
        HRRequest managerRequest = new ManagerRequest();

        managerRequest.setNextRequest(directorRequest);

        Request request1 = new Request(RequestType.NEW_HIRE, createEmployee);
        managerRequest.handleRequest(request1);

        Request request2 = new Request(RequestType.SALARY, createEmployee);
        managerRequest.handleRequest(request2);

    }
}
