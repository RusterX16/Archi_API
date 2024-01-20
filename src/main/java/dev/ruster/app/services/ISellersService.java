package dev.ruster.app.services;

import org.springframework.http.ResponseEntity;

public interface ISellersService {

    ResponseEntity<String> getAllSellers();
    ResponseEntity<String> getSellerById(long id);
    ResponseEntity<String> createSeller(String seller);
    ResponseEntity<String> updateSeller(long id, String seller);
    ResponseEntity<String> deleteAllSellers();
    ResponseEntity<String> deleteSellerById(long id);
}
