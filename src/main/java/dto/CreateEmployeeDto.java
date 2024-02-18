package dto;

import entity.Project;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
public class CreateEmployeeDto {
    private String voornaam;
    private String achternaam;
    private BigDecimal salary;
    private Long managerId;
    private Long departmentId;
    private List<Project> projects;
    //Employee details
    private String adress;
    private String bankNaam;
    private String telefoonNummer;
}
