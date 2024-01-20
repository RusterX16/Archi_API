package dev.ruster.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@Getter
@ToString
@AllArgsConstructor
public class Seller {

    private long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String address;
    private String city;
    private String state;
    private String zip;

    public void update(long id, @NotNull Seller seller) {
        this.id = id;
        this.name = seller.name;
        this.email = seller.email;
        this.phone = seller.phone;
        this.password = seller.password;
        this.address = seller.address;
        this.city = seller.city;
        this.state = seller.state;
        this.zip = seller.zip;
    }
}
