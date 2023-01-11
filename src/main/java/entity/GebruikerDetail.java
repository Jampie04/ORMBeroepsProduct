package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class GebruikerDetail {

    @Id
    @GeneratedValue
    private Long id;
    private String adress;
    private String bankNaam;
    private String geboorteDatum;

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getBankNaam() {
        return bankNaam;
    }

    public void setBankNaam(String bankNaam) {
        this.bankNaam = bankNaam;
    }

    public String getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(String geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }
}
