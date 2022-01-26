package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll() {
        Iterable<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Integer id) {
        productService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> detail(@PathVariable Integer id) {
        Optional<Product> product = productService.findById(id);
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> getAll() {
        Iterable<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> detailCategories(@PathVariable Integer id) {
        Optional<Category> category = categoryService.findById(id);
        return new ResponseEntity<>(category.get(), HttpStatus.OK);
    }

    @GetMapping("name/{q}")
    public ResponseEntity<Iterable<Product>> search(String q) {
        Iterable<Product> products;
        if (q=="") {
            products = productService.findAll();
        } else {
            products = productService.findByNameContaining(q);

        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("price/{price}/{price2}")
    public ResponseEntity<Iterable<Product>> findByPrice(Integer price, Integer price2){
        Iterable<Product> products;
        if (price!=null&price2==null||price2!=null&price==null){
            products=productService.findByPrice(price);
        }
        else if (price==null&price2==null){
            products = productService.findAll();
        }
        else {
            products=productService.findByPriceBetween(price,price2);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
