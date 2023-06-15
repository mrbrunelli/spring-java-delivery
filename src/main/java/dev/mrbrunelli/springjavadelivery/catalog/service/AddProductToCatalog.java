package dev.mrbrunelli.springjavadelivery.catalog.service;

import dev.mrbrunelli.springjavadelivery.catalog.Catalog;
import dev.mrbrunelli.springjavadelivery.catalog.CatalogRepository;
import dev.mrbrunelli.springjavadelivery.catalog.exception.CatalogNotFound;
import dev.mrbrunelli.springjavadelivery.product.Product;
import dev.mrbrunelli.springjavadelivery.product.ProductRepository;
import dev.mrbrunelli.springjavadelivery.product.exception.ProductNotFound;
import dev.mrbrunelli.springjavadelivery.shared.ConflictException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
        Catalog catalog = catalogRepository.findById(catalogId).orElseThrow(CatalogNotFound::new);
        Product product = productRepository.findById(productId).orElseThrow(ProductNotFound::new);
        if (catalog.existsAssociatedProduct(product)) {
            throw new ConflictException("this product is already associated with this catalog");
        }
        catalog.addProduct(product);
        product.addCatalog(catalog);
    }
}
