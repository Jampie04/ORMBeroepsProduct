import Menu.Menu;
import Request.DirectorRequest;
import Request.HRRequest;
import Request.ManagerRequest;
import Request.RequestType;
import entity.*;
import repository.EmployeeRepository;
import service.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    /*    GebruikerService gebruikerService = new GebruikerService();
        GebruikerDetailService gebruikerDetailService = new GebruikerDetailService();

//
//        System.out.println(gebruikerService.getGebruikers());

        GebruikerDetail gebruikerDetail = new GebruikerDetail();
        gebruikerDetail.setAdress("Elisabethshof #4");
        gebruikerDetail.setBankNaam("DSB Bank");
        gebruikerDetail.setGeboorteDatum("12-12-1993");

        GebruikerDetail detail = gebruikerDetailService.createGebruikerDetail(gebruikerDetail);

        Gebruiker createGebruiker = new Gebruiker();
        createGebruiker.setVoornaam("Sheik");
        createGebruiker.setAchternaam("Neil");
        createGebruiker.setUsername("sheikNeil");
        createGebruiker.setPassword("*****");
        createGebruiker.setGebruikerDetail(detail);
        System.out.println("gebruiker: " + createGebruiker.getGebruikerDetail().getAdress());
        gebruikerService.createGebruiker(createGebruiker);

        EmployeeDetailService employeeDetailService = new EmployeeDetailService();
        EmployeeService employeeService = new EmployeeService();

        EmployeeDetail employeeDetail = new EmployeeDetail();
        employeeDetail.setAdress("Geyersvlijt #100");
        employeeDetail.setBankNaam("DSB Bank");
        employeeDetail.setTelefoonNummer("+5971234567");

        EmployeeDetail detail1 = employeeDetailService.createEmployeeDetail(employeeDetail);

        Employee createEmployee = new Employee();
        createEmployee.setVoornaam("Sheik");
        createEmployee.setAchternaam("Neil");
        createEmployee.setSalary(2000);
        createEmployee.setEmployeeDetail(detail1);
        System.out.println("employee: " + createEmployee.getEmployeeDetail().getAdress());
        employeeService.createEmployee(createEmployee);*/

    /*    DepartmentService departmentService = new DepartmentService();
       Department department = new Department();
       department.setDeptname("HRM");
        departmentService.createDepartment(department);

        EmployeeDetailService employeeDetailService = new EmployeeDetailService();
        EmployeeService employeeService = new EmployeeService();

        EmployeeDetail employeeDetail = new EmployeeDetail();
        employeeDetail.setAdress("atlasstr #100");
        employeeDetail.setBankNaam("DSB Bank");
        employeeDetail.setTelefoonNummer("+5971234567");

        EmployeeDetail detail1 = employeeDetailService.createEmployeeDetail(employeeDetail);

        Employee createEmployee = new Employee();
        createEmployee.setVoornaam("Girish");
        createEmployee.setAchternaam("Oemrawsingh");
        createEmployee.setSalary(6700);
        createEmployee.setEmployeeDetail(detail1);
        createEmployee.setDepartment(department);
        System.out.println("employee: " + createEmployee.getEmployeeDetail().getAdress());
        employeeService.createEmployee(createEmployee);*/







   /*     List<Gebruiker> gebruikers = gebruikerService.getGebruikers();
        gebruikers.forEach( gebruiker -> {
            System.out.println("Voornaam = " + gebruiker.getVoornaam() + "Achternaam = " + gebruiker.getAchternaam() + " Adres: " + gebruiker.getGebruikerDetail().getAdress());
        });*/

        EmployeeService employeeService = new EmployeeService();

        //Dit zijn de CRUD handelingen
//        employeeService.deleteEmployee();
//        employeeService.updateSalary(152l, 600000);
//        Employee employee = employeeService.findEmployee(152l);
//        System.out.println(employee);

        while (true){
            Menu.showMenu();
            Menu.menuInput();


        }





    }
}
