package dev.mrbrunelli.springjavadelivery.catalog.dto;

import dev.mrbrunelli.springjavadelivery.catalog.Catalog;
import lombok.Data;

@Data
public class NewCatalogDTO {
    private String name;

    public Catalog toCatalog() {
        Catalog catalog = new Catalog();
        catalog.setName(name);
        return catalog;
    }
}
