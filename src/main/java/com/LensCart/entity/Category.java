package com.LensCart.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    private Integer categoryId;
    private String name;


    @OneToMany
    private List<Product>  products;


    public void addProduct(Product p){
        this.products.add(p);
    }
}
