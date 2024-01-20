package dev.ruster.app.repositories;

import dev.ruster.app.models.Command;
import dev.ruster.app.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommandsRepository {

    private final EntityManager entityManager;

    public CommandsRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Product> getProducts() {
        String queryString = "SELECT * FROM commands";
        Query query = entityManager.createNativeQuery(queryString, Command.class);
        return query.getResultList();
    }
}
