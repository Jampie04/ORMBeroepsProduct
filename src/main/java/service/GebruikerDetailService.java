package service;

import configuration.JPAConfiguration;
import entity.Gebruiker;
import entity.GebruikerDetail;
import repository.GebruikerDetailRepository;

public class GebruikerDetailService {

    private GebruikerDetailRepository gebruikerDetailRepository;

    public GebruikerDetailService() {
        this.gebruikerDetailRepository = new GebruikerDetailRepository(JPAConfiguration.getEntityManager());
    }

    public GebruikerDetail createGebruikerDetail(GebruikerDetail gebruikerDetail){
        return gebruikerDetailRepository.createGebruikerDetail(gebruikerDetail);
    }
}
