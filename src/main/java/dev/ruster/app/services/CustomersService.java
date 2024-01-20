package dev.ruster.app.services;

import dev.ruster.app.models.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService {

    public String mockedCustomers() {
        List<Customer> list = List.of(
                new Customer(1, "John Doe", "johndoe@example.com", "+123456789", "123 Main St"),
                new Customer(2, "Alice Smith", "alice.smith@example.com", "+987654321", "456 Elm St"),
                new Customer(3, "Bob Johnson", "bob.johnson@example.com", "+111223344", "789 Oak St")
        );

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(list);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error converting to JSON";
        }
    }
}
