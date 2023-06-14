package dev.mrbrunelli.springjavadelivery.catalog.service;

import dev.mrbrunelli.springjavadelivery.catalog.Catalog;
import dev.mrbrunelli.springjavadelivery.catalog.CatalogRepository;
import dev.mrbrunelli.springjavadelivery.catalog.dto.CatalogWithProductsView;
import dev.mrbrunelli.springjavadelivery.catalog.exception.CatalogNotFound;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCatalogById {
    private final CatalogRepository repository;

    public GetCatalogById(CatalogRepository repository) {
        this.repository = repository;
    }

    public CatalogWithProductsView execute(Long id) {
        Optional<Catalog> catalogOptional = repository.findById(id);
        if (catalogOptional.isEmpty()) {
            throw new CatalogNotFound();
        }
        Catalog catalog = catalogOptional.get();
        return CatalogWithProductsView.fromCatalog(catalog);
    }
}
