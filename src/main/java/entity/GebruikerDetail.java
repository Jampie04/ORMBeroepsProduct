package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GebruikerDetail {

    @Id
    @GeneratedValue
    private Long id;
    private String adress;
    private String bankNaam;
    private String geboorteDatum;
}
