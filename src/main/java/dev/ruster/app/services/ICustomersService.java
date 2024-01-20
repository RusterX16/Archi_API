package dev.ruster.app.services;

import org.springframework.http.ResponseEntity;

public interface ICustomersService {

    ResponseEntity<String> getAllCustomers();
    ResponseEntity<String> getCustomerById(long id);
    ResponseEntity<String> createCustomer(String customer);
    ResponseEntity<String> updateCustomer(long id, String customer);
    ResponseEntity<String> deleteAllCustomers();
    ResponseEntity<String> deleteCustomerById(long id);
}
