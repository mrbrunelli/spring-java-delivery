package dev.mrbrunelli.springjavadelivery.controller;

import dev.mrbrunelli.springjavadelivery.model.Product;
import dev.mrbrunelli.springjavadelivery.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository repository;

    public ProductController(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    @GetMapping
    public List<Product> getAll() {
        return repository.findAll();
    }
}
