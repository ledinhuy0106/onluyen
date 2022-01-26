package com.example.demo.service;

import com.example.demo.model.Product;

public interface ProductService extends GennerralService<Product> {
    Iterable<Product> findByNameContaining(String name);

}
