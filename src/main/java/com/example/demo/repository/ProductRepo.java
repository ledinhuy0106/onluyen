package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    Iterable<Product> findByNameContaining(String name);
    Iterable<Product> findByPriceBetween(int price, int price2);
    Iterable<Product> findByPrice(int price);
}
