package dev.ruster.app.services;

import dev.ruster.app.models.Command;
import dev.ruster.app.models.Product;
import org.springframework.http.ResponseEntity;

public interface ICommandsService {

    ResponseEntity<String> getAllCommands();
    ResponseEntity<String> getCommandById(long id);
    ResponseEntity<String> createCommand(Command product);
    ResponseEntity<String> updateCommand(long id, Command product);
    ResponseEntity<String> deleteAllCommands();
    ResponseEntity<String> deleteCommandById(long id);
}
