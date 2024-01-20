package dev.ruster.app.controllers;

import dev.ruster.app.models.Product;
import dev.ruster.app.services.ProductsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Products", description = "Endpoints related to product management including creating, reading, updating, and deleting products.")
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @Operation(summary = "Get all products", description = "Get a list of all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "503", description = "Service Unavailable")
    })
    @GetMapping("/products")
    public ResponseEntity<String> getProduct() {
        return productsService.getAllProducts();
    }

    @Operation(summary = "Get product by id", description = "Get a single product by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "503", description = "Service Unavailable")
    })
    @GetMapping("/products/{id}")
    public ResponseEntity<String> getProductById(@PathVariable("id") Long id) {
        return productsService.getProductById(id);
    }

    @Operation(summary = "Create new product", description = "Create a new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "503", description = "Service Unavailable")
    })
    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        return productsService.createProduct(product);
    }

    @Operation(summary = "Update product by id", description = "Update an existing product by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "503", description = "Service Unavailable")
    })
    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productsService.updateProduct(id, product);
    }

    @Operation(summary = "Delete all products", description = "Delete all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "503", description = "Service Unavailable")
    })
    @DeleteMapping("/products")
    public ResponseEntity<String> deleteAllProducts() {
        return productsService.deleteAllProducts();
    }

    @Operation(summary = "Delete product by id", description = "Delete a single product by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "503", description = "Service Unavailable")
    })
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") Long id) {
        return productsService.deleteProductById(id);
    }
}
