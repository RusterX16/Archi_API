package dev.ruster.app.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ruster.app.models.Command;
import dev.ruster.app.repositories.CommandsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandsService {

    private final CommandsRepository commandsRepository;

    public CommandsService(CommandsRepository commandsRepository) {
        this.commandsRepository = commandsRepository;
    }

    public String mockedCommands() {
        List<Command> commands = List.of(
                new Command(1, 1, 1, 2, "99.98"),  // Order of 2 Amazon Echo Dot (4th Gen) for customer 1
                new Command(2, 1, 2, 1, "129.99"), // Order of 1 Amazon Kindle Paperwhite for customer 1
                new Command(3, 2, 3, 3, "149.97"), // Order of 3 Amazon Fire TV Stick 4K for customer 2
                new Command(4, 2, 4, 1, "129.99"), // Order of 1 Amazon Echo Show 8 for customer 2
                new Command(5, 3, 5, 2, "39.98"),  // Order of 2 AmazonBasics Laptop Stands for customer 3
                new Command(6, 3, 6, 2, "259.98"), // Order of 2 Amazon Echo Buds for customer 3
                new Command(7, 3, 7, 5, "39.95")   // Order of 5 AmazonBasics USB-C to USB-A Cables for customer 3
        );
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(commands);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error converting to JSON";
        }
    }
}
