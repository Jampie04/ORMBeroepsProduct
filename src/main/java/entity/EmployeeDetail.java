package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class EmployeeDetail {

    @Id
    @GeneratedValue
    private Long id;
    private String adress;
    private String bankNaam;
    private String telefoonNummer;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

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

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(String telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

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
