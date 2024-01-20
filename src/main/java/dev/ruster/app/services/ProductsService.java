package dev.ruster.app.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ruster.app.models.Product;
import dev.ruster.app.repositories.ProductsRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ProductsService implements IProductsService {

    private final ProductsRepository productsRepository;
    private final AtomicLong counter = new AtomicLong();
    private final List<Product> mockedProducts;
    private final ObjectMapper objectMapper;


    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
        this.mockedProducts = new ArrayList<>(List.of(
                new Product(1, "Amazon Echo Dot (4th Gen)", "Smart speaker with Alexa, Charcoal", 49.99, 10, "echo_dot.jpg", "Smart Speakers"),
                new Product(2, "Amazon Kindle Paperwhite", "Waterproof e-reader with a high-resolution display", 129.99, 15, "kindle_paperwhite.jpg", "E-Readers"),
                new Product(3, "Amazon Fire TV Stick 4K", "Streaming media player with Alexa Voice Remote", 49.99, 20, "fire_tv_stick_4k.jpg", "Media Players"),
                new Product(4, "Amazon Echo Show 8", "HD smart display with Alexa, Sandstone", 129.99, 8, "echo_show_8.jpg", "Smart Displays"),
                new Product(5, "AmazonBasics Laptop Stand", "Laptop stand with adjustable height, Silver", 19.99, 30, "laptop_stand.jpg", "Computer Accessories"),
                new Product(6, "Amazon Echo Buds", "Wireless earbuds with active noise cancellation", 129.99, 12, "echo_buds.jpg", "Headphones"),
                new Product(7, "AmazonBasics USB-C to USB-A Cable", "USB Type-C to USB Type-A charging cable, 3 Feet", 7.99, 50, "usb_c_cable.jpg", "Cables"),
                new Product(8, "Ring Video Doorbell Pro 2", "Advanced video doorbell with 3D Motion Detection", 249.99, 6, "ring_doorbell.jpg", "Home Security"),
                new Product(9, "Amazon Basics Gaming Mouse", "Wired gaming mouse with customizable RGB lighting", 29.99, 25, "gaming_mouse.jpg", "Gaming Accessories"),
                new Product(10, "Amazon Fire HD 10 Tablet", "10.1-inch tablet with Full HD display and Alexa", 149.99, 10, "fire_hd_10_tablet.jpg", "Tablets"))
        );
        counter.set(mockedProducts.getLast().getId());
        objectMapper = new ObjectMapper();
    }

    @Override
    public ResponseEntity<String> createProduct(@NotNull Product newProduct) {
        newProduct.setId(counter.incrementAndGet());
        mockedProducts.add(newProduct);

        try {
            String jsonProduct = objectMapper.writeValueAsString(newProduct);
            return ResponseEntity.status(HttpStatus.CREATED).body(jsonProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting product to JSON");
        }
    }

    @Override
    public ResponseEntity<String> updateProduct(long id, Product productToUpdate) {
        Product existingProduct = mockedProducts.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);

        if (existingProduct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        existingProduct.update(id, productToUpdate);

        try {
            String updatedProductJson = objectMapper.writeValueAsString(existingProduct);
            return ResponseEntity.ok(updatedProductJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting to JSON");
        }
    }

    @Override
    public ResponseEntity<String> getAllProducts() {
        try {
            return ResponseEntity.ok(objectMapper.writeValueAsString(mockedProducts));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting to JSON");
        }
    }

    @Override
    public ResponseEntity<String> getProductById(long id) {
        return mockedProducts.stream().filter(product -> product.getId() == id).findFirst().map(product -> {
            try {
                return ResponseEntity.ok(objectMapper.writeValueAsString(product));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting to JSON");
            }
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found"));
    }

    @Override
    public ResponseEntity<String> deleteAllProducts() {
        mockedProducts.clear();
        return ResponseEntity.ok("All products deleted successfully");
    }

    @Override
    public ResponseEntity<String> deleteProductById(long id) {
        boolean removed = mockedProducts.removeIf(product -> product.getId() == id);

        if (!removed) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.ok("Product deleted successfully");
    }
}
