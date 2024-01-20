package dev.ruster.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@Getter
@ToString
@AllArgsConstructor
public class Product {

    @Setter private long id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private String image;
    private String category;

    public void update(long id, @NotNull Product product) {
        this.id = id;
        this.name = product.name;
        this.description = product.description;
        this.price = product.price;
        this.stock = product.stock;
        this.image = product.image;
        this.category = product.category;
    }
}
