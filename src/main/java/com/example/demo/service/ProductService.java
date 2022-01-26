package com.example.demo.service;

import com.example.demo.model.Product;

public interface ProductService extends GennerralService<Product> {
    Iterable<Product> findByNameContaining(String name);
    Iterable<Product> findByPriceBetween(int price, int price2);
    Iterable<Product> findByPrice(int price);

}
