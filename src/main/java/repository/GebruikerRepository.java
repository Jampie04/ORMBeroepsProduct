package repository;

import entity.Gebruiker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class GebruikerRepository {

    private EntityManager entityManager;

    public GebruikerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Gebruiker> getGebruikers() {
        String query = "select g from Gebruiker g";
        TypedQuery<Gebruiker> typedQuery = entityManager.createQuery(query, Gebruiker.class);
        System.out.println(typedQuery.getResultList());
        List<Gebruiker> dienstList = typedQuery.getResultList();
        return dienstList;
    }

    public Gebruiker createGebruiker(Gebruiker gebruiker){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(gebruiker);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return gebruiker;
    }
}
