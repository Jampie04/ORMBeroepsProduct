package service;

import configuration.JPAConfiguration;
import entity.Gebruiker;
import repository.GebruikerRepository;

import java.util.List;

public class GebruikerService {

    private final GebruikerRepository repository;

    public GebruikerService() {
        this.repository = new GebruikerRepository(JPAConfiguration.getEntityManager());
    }

    public List<Gebruiker> getGebruikers() {
        return repository.getGebruikers();
    }

    public Gebruiker createGebruiker(Gebruiker gebruiker) {
        return repository.createGebruiker(gebruiker);
    }
}
