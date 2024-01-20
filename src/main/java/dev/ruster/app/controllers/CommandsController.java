package dev.ruster.app.controllers;

import dev.ruster.app.services.CommandsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Commands", description = "Endpoints related to command management including creating, reading, updating, and deleting commands.")
public class CommandsController {

    private final CommandsService commandService;

    public CommandsController(CommandsService commandService) {
        this.commandService = commandService;
    }

    @Operation(summary = "Get all commands", description = "Get all commands")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping("/commands")
    public String getCommands() {
        return commandService.mockedCommands();
    }

    @Operation(summary = "Get command by id", description = "Get command by id")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping("/commands/{id}")
    public String getCommandById(@PathVariable String id) {
        return commandService.mockedCommands();
    }

    @Operation(summary = "Create new command", description = "Create new command")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping("/commands")
    public String createCommands() {
        return commandService.mockedCommands();
    }

    @Operation(summary = "Update command by id", description = "Update command by id")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PutMapping("/commands/{id}")
    public String updateCommands(@PathVariable String id) {
        return commandService.mockedCommands();
    }

    @Operation(summary = "Delete all commands", description = "Delete all commands")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @DeleteMapping("/commands")
    public String deleteCommands() {
        return commandService.mockedCommands();
    }

    @Operation(summary = "Delete command by id", description = "Delete command by id")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @DeleteMapping("/commands/{id}")
    public String deleteCommands(@PathVariable String id) {
        return commandService.mockedCommands();
    }
}
