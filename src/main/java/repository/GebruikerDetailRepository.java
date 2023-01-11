package repository;

import entity.Gebruiker;
import entity.GebruikerDetail;
import jakarta.persistence.EntityManager;

public class GebruikerDetailRepository {

    private EntityManager entityManager;

    public GebruikerDetailRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public GebruikerDetail createGebruikerDetail(GebruikerDetail gebruikerDetail) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(gebruikerDetail);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return gebruikerDetail;
    }
}
