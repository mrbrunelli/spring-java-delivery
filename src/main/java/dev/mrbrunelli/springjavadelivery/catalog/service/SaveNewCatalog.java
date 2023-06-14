package dev.mrbrunelli.springjavadelivery.catalog.service;

import dev.mrbrunelli.springjavadelivery.catalog.Catalog;
import dev.mrbrunelli.springjavadelivery.catalog.CatalogRepository;
import dev.mrbrunelli.springjavadelivery.catalog.dto.CatalogView;
import dev.mrbrunelli.springjavadelivery.catalog.dto.NewCatalogDTO;
import org.springframework.stereotype.Service;

@Service
public class SaveNewCatalog {
    private final CatalogRepository repository;

    public SaveNewCatalog(CatalogRepository repository) {
        this.repository = repository;
    }

    public CatalogView execute(NewCatalogDTO dto) {
        Catalog catalog = dto.toCatalog();
        Catalog savedCatalog = repository.save(catalog);
        return CatalogView.fromCatalog(savedCatalog);
    }
}
