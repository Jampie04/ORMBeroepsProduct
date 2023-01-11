package entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String voornaam;
    private String achternaam;
    private Integer salary;

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    private Long managerId;

    @OneToOne
    private EmployeeDetail employeeDetailId;

    //Die OneToMany/ManyToOne mapping moet in beide entities voorkomen
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "department_id")
    private Department department;


    @ManyToMany(targetEntity = Project.class ,cascade = {CascadeType.ALL})
    @JoinTable(name = "employee_project", joinColumns = {@JoinColumn(name = "employee_id")},
    inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private Set<Project> project = new HashSet<>();


    public Set<Project> getProject() {
        return project;
    }

    public void setProject(Set<Project> project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public EmployeeDetail getEmployeeDetail(){
        return employeeDetailId;
    }

    public void setEmployeeDetail(EmployeeDetail employeeDetail) {
        this.employeeDetailId = employeeDetail;
    }

    public Department getDepartment(){
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    /*public Project getProject(){
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }*/

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", voornaam = '" + voornaam + '\'' +
                ", achternaam = '" + achternaam + '\'' +
                ", salary = " + salary +
                ", employeeDetailId = " + employeeDetailId +
                ", department = " + department +
                '}';
    }
}
