package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductImpl implements ProductService{
    @Autowired
    ProductRepo productRepo;
    @Override
    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public void save(Product product) {
       productRepo.save(product);
    }

    @Override
    public void remove(int id) {
      productRepo.deleteById(id);
    }

    @Override
    public Iterable<Product> findByNameContaining(String name) {
        return productRepo.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Product> findByPriceBetween(int price, int price2) {
        return productRepo.findByPriceBetween(price,price2);
    }

    @Override
    public Iterable<Product> findByPrice(int price) {
        return productRepo.findByPrice(price);
    }
}
