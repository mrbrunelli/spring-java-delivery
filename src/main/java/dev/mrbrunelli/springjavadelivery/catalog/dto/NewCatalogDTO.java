package dev.mrbrunelli.springjavadelivery.catalog.dto;

import dev.mrbrunelli.springjavadelivery.catalog.Catalog;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class NewCatalogDTO {
    @NotNull
    private String name;

    public Catalog toCatalog() {
        Catalog catalog = new Catalog();
        catalog.setName(name);
        return catalog;
    }
}
