package dev.ruster.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@Getter
@ToString
@AllArgsConstructor
public class Customer {

    private long id;
    private String name;
    private String email;
    private String phone;
    private String address;

    public void update(long id, @NotNull Customer customer) {
        this.id = id;
        this.name = customer.name;
        this.email = customer.email;
        this.phone = customer.phone;
        this.address = customer.address;
    }
}
