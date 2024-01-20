package dev.ruster.app.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ruster.app.models.Seller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellersService {

    public String mockedSellers() {
        List<Seller> sellers = List.of(
                new Seller(1, "Funny Seller 1", "funnyseller1@example.com", "123-456-7890", "funnypassword1", "123 Joke St", "Humorville", "Comedy State", "98765"),
                new Seller(2, "Haha Seller 2", "hahaseller2@example.com", "987-654-3210", "hahapassword2", "456 Gag Rd", "Laughington", "Jokes State", "12345"),
                new Seller(3, "Pun-tastic Seller 3", "puntasticseller3@example.com", "555-555-5555", "punpassword3", "789 Quirk Ave", "Punsville", "Wordplay State", "67890")
        );

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(sellers);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error converting to JSON";
        }
    }
}
