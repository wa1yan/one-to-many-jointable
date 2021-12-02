package com.example.demoonetomany.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
// --Many - Join table
// --One - Join Column
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Category {
//Parent
    //Collection - List - Set - Map
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    //cascade - > persit
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    public Category() {

    }

    public void addProduct(Product product){
       // product.setCategory(this);
        products.add(product);
    }

    public void removeProduct(Product product){
        //product.setCategory(null);
        this.products.remove(product);
    }
}
