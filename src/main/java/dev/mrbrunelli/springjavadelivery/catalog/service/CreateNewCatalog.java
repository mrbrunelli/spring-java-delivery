package dev.mrbrunelli.springjavadelivery.catalog.service;

import dev.mrbrunelli.springjavadelivery.catalog.Catalog;
import dev.mrbrunelli.springjavadelivery.catalog.CatalogRepository;
import dev.mrbrunelli.springjavadelivery.catalog.dto.CatalogView;
import dev.mrbrunelli.springjavadelivery.catalog.dto.NewCatalogDTO;

public class CreateNewCatalog {
    private final CatalogRepository repository;

    public CreateNewCatalog(CatalogRepository repository) {
        this.repository = repository;
    }

    public CatalogView execute(NewCatalogDTO dto) {
        Catalog catalog = dto.toCatalog();
        Catalog savedCatalog = repository.save(catalog);
        return CatalogView.fromCatalog(savedCatalog);
    }
}
