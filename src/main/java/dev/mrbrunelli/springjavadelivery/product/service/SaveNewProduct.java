package dev.mrbrunelli.springjavadelivery.product.service;

import dev.mrbrunelli.springjavadelivery.product.Product;
import dev.mrbrunelli.springjavadelivery.product.ProductRepository;
import dev.mrbrunelli.springjavadelivery.product.dto.NewProductDTO;
import dev.mrbrunelli.springjavadelivery.product.dto.ProductView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaveNewProduct {
    private final ProductRepository repository;

    public SaveNewProduct(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ProductView execute(NewProductDTO dto) {
        Product product = dto.toProduct();
        return ProductView.fromProduct(repository.save(product));
    }
}
