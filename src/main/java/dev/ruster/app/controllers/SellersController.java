package dev.ruster.app.controllers;

import dev.ruster.app.services.SellersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Sellers", description = "Endpoints related to seller management including creating, reading, updating, and deleting sellers.")
public class SellersController {

    private final SellersService sellersService;

    public SellersController(SellersService sellersService) {
        this.sellersService = sellersService;
    }

    @Operation(summary = "Get all sellers", description = "Get all sellers")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping("/sellers")
    public String getSellers() {
        return sellersService.mockedSellers();
    }

    @Operation(summary = "Get seller by id", description = "Get seller by id")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping("/sellers/{id}")
    public String getSellerById(@PathVariable("id") Long id) {
        return sellersService.mockedSellers();
    }

    @Operation(summary = "Create new seller", description = "Create new seller")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping("/sellers")
    public String createSellers() {
        return sellersService.mockedSellers();
    }

    @Operation(summary = "Update seller by id", description = "Update seller by id")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PutMapping("/sellers/{id}")
    public String updateSellers(@PathVariable String id) {
        return sellersService.mockedSellers();
    }

    @Operation(summary = "Delete all sellers", description = "Delete all sellers")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @DeleteMapping("/sellers")
    public String deleteSellers() {
        return sellersService.mockedSellers();
    }

    @Operation(summary = "Delete seller by id", description = "Delete seller by id")
    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "401", description = "Unauthorized")
    @ApiResponse(responseCode = "403", description = "Forbidden")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @DeleteMapping("/sellers/{id}")
    public String deleteSellerById(@PathVariable Long id) {
        return sellersService.mockedSellers();
    }
}
