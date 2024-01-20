package dev.ruster.app.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SellersRepository {

    private final EntityManager entityManager;

    public SellersRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<String> getSellers() {
        String queryString = "SELECT * FROM sellers";
        Query query = entityManager.createNativeQuery(queryString, String.class);
        return query.getResultList();
    }
}
