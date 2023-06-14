package dev.mrbrunelli.springjavadelivery.catalog.service;

import dev.mrbrunelli.springjavadelivery.catalog.Catalog;
import dev.mrbrunelli.springjavadelivery.catalog.CatalogRepository;
import dev.mrbrunelli.springjavadelivery.catalog.dto.CatalogView;
import dev.mrbrunelli.springjavadelivery.catalog.exception.CatalogNotFound;
import dev.mrbrunelli.springjavadelivery.product.Product;
import dev.mrbrunelli.springjavadelivery.product.ProductRepository;
import dev.mrbrunelli.springjavadelivery.product.exception.ProductNotFound;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AddProductToCatalog {
    private final CatalogRepository catalogRepository;
    private final ProductRepository productRepository;

    public AddProductToCatalog(CatalogRepository catalogRepository, ProductRepository productRepository) {
        this.catalogRepository = catalogRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public void execute(Long catalogId, Long productId) {
        Optional<Catalog> catalogOptional = catalogRepository.findById(catalogId);
        if (catalogOptional.isEmpty()) {
            throw new CatalogNotFound();
        }
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new ProductNotFound();
        }
        Catalog catalog = catalogOptional.get();
        Product product = productOptional.get();
        catalog.getProducts().add(product);
        product.getCatalogs().add(catalog);
        catalogRepository.save(catalog);
        productRepository.save(product);
    }
}
