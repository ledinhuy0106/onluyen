package com.example.demo.service;

import java.util.Optional;

public interface GennerralService<U> {
    Iterable<U> findAll() ;

    Optional<U> findById(int id);

    void save(U u);

    void remove(int id);
}
