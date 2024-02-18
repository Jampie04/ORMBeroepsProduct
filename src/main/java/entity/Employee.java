package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String voornaam;
    private String achternaam;
    private BigDecimal salary;
    private Long managerId;

    @OneToOne
    private EmployeeDetail employeeDetailId;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "department_id")
    private Department department;


    @ManyToMany(targetEntity = Project.class ,cascade = {CascadeType.ALL})
    @JoinTable(name = "employee_project", joinColumns = {@JoinColumn(name = "employee_id")},
    inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private List<Project> project;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", salary=" + salary +
                ", managerId=" + managerId +
                ", employeeDetailId=" + employeeDetailId +
                ", department=" + department +
                ", project=" + project +
                '}';
    }
}
