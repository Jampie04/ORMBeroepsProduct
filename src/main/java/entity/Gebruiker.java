package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Gebruiker {

    @Id
    @GeneratedValue
    private Long id;
    private String voornaam;
    private String achternaam;
    private String username;
    private String password;

    @OneToOne
    private GebruikerDetail gebruikerDetailId;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GebruikerDetail getGebruikerDetail() {
        return gebruikerDetailId;
    }

    public void setGebruikerDetail(GebruikerDetail gebruikerDetail) {
        this.gebruikerDetailId = gebruikerDetail;
    }


}
