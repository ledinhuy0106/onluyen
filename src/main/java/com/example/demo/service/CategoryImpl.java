package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryImpl implements CategoryService{
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepo.findById(id);
    }

    @Override
    public void save(Category category) {
    }

    @Override
    public void remove(int id) {
    }
}
