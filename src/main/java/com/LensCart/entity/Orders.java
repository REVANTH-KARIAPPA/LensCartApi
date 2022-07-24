package com.LensCart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToMany
    @JoinTable(name ="ordered_products",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "product_productId"))
    private Set<Product> products;
    @JsonIgnore
    @ManyToOne
    private User users;


    public void putProduct(Product product) {
        products.add(product);
    }
}
