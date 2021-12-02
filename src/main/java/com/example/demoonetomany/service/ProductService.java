package com.example.demoonetomany.service;

import com.example.demoonetomany.entities.Category;
import com.example.demoonetomany.entities.Product;
import com.example.demoonetomany.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void createDB(){
         Category c1= new Category();
         c1.setName("Fruits");

        Category c2= new Category();
        c2.setName("Meat");

        Product p1 = new Product("Apple",2000,100);
        Product p2 = new Product("Orange",2000,100);

        Product p3 = new Product("Pork",2000,100);
        Product p4 = new Product("Chicken",2000,100);

        c1.getProducts().add(p1);
        c1.getProducts().add(p2);
        c2.getProducts().add(p3);
        c2.getProducts().add(p4);

        categoryRepository.save(c1);
        categoryRepository.save(c2);
    }

    @Transactional
    public void insertNewProductByCategoryName(String categoryName){
        Category category = categoryRepository.fetchByName(categoryName);
        Product product = new Product("Grape",4000,12);
        category.addProduct(product);
        categoryRepository.save(category);
    }

    @Transactional
    public void deleteLastProduct(){
        Category category = categoryRepository.fetchByName("Fruits");
        List<Product> products = category.getProducts();
        category.removeProduct(products.get(products.size()-1));
    }

    @Transactional
    public void deleteFirstProduct(){
        Category category = categoryRepository.fetchByName("Meat");
        List<Product> products = category.getProducts();
        category.removeProduct(products.get(0));
    }
}
