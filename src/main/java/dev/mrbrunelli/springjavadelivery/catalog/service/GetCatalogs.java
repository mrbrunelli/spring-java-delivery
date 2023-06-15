package dev.mrbrunelli.springjavadelivery.catalog.service;

import dev.mrbrunelli.springjavadelivery.catalog.Catalog;
import dev.mrbrunelli.springjavadelivery.catalog.CatalogRepository;
import dev.mrbrunelli.springjavadelivery.catalog.dto.CatalogWithProductsView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCatalogs {
    private final CatalogRepository repository;

    public GetCatalogs(CatalogRepository repository) {
        this.repository = repository;
    }

    public List<CatalogWithProductsView> execute() {
        List<Catalog> catalogs = repository.findAll();
        return CatalogWithProductsView.fromCatalogList(catalogs);
    }
}
