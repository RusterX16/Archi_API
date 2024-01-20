package dev.ruster.app.repositories;

import dev.ruster.app.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsRepository {

    private final EntityManager entityManager;

    public ProductsRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Product> getProducts() {
        String queryString = "SELECT * FROM products";
        Query query = entityManager.createNativeQuery(queryString, Product.class);
        return query.getResultList();
    }
}
