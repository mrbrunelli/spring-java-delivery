package dev.mrbrunelli.springjavadelivery.product.service;

import dev.mrbrunelli.springjavadelivery.product.ProductRepository;
import dev.mrbrunelli.springjavadelivery.product.dto.ProductView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProducts {
    private final ProductRepository repository;

    public GetProducts(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductView> execute(Boolean isFeatured) {
        if (isFeatured) {
            return ProductView.fromProductList(repository.findByIsFeaturedTrue());
        }
        return ProductView.fromProductList(repository.findAll());
    }
}
