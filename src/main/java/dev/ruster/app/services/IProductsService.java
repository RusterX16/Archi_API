package dev.ruster.app.services;

import dev.ruster.app.models.Product;
import org.springframework.http.ResponseEntity;

public interface IProductsService {

    ResponseEntity<String> getAllProducts();
    ResponseEntity<String> getProductById(long id);
    ResponseEntity<String> createProduct(Product product);
    ResponseEntity<String> updateProduct(long id, Product product);
    ResponseEntity<String> deleteAllProducts();
    ResponseEntity<String> deleteProductById(long id);
}
