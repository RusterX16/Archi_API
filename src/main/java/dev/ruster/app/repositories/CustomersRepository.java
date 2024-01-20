package dev.ruster.app.repositories;

import dev.ruster.app.models.Customer;
import dev.ruster.app.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomersRepository {

    private final EntityManager entityManager;

    public CustomersRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Product> getCustomers() {
        String queryString = "SELECT * FROM customers";
        Query query = entityManager.createNativeQuery(queryString, Customer.class);
        return query.getResultList();
    }
}
