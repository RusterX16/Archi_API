package dev.ruster.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@Getter
@ToString
@AllArgsConstructor
public class Command {

    private long id;
    private long customerId;
    private long productId;
    private int quantity;
    private String price;

    public void update(long id, @NotNull Command command) {
        this.id = id;
        this.customerId = command.customerId;
        this.productId = command.productId;
        this.quantity = command.quantity;
        this.price = command.price;
    }
}
