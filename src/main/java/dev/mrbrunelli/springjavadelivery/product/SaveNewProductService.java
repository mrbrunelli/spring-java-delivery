package dev.mrbrunelli.springjavadelivery.product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaveNewProductService {
    private final ProductRepository repository;

    public SaveNewProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Product execute(SaveNewProductDTO dto) {
        Product product = dto.toProduct();
        return repository.save(product);
    }
}
