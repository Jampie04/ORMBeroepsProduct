package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EmployeeDetail {

    @Id
    @GeneratedValue
    private Long id;
    private String adress;
    private String bankNaam;
    private String telefoonNummer;

    @Override
    public String toString() {
        return "EmployeeDetail{" +
                "id=" + id +
                ", adress='" + adress + '\'' +
                ", bankNaam='" + bankNaam + '\'' +
                ", telefoonNummer='" + telefoonNummer + '\'' +
                '}';
    }
}
