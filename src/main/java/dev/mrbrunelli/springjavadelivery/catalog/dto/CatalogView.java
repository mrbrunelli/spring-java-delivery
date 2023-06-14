package dev.mrbrunelli.springjavadelivery.catalog.dto;

import dev.mrbrunelli.springjavadelivery.catalog.Catalog;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CatalogView {
    private Long id;
    private String name;

    public static CatalogView fromCatalog(Catalog catalog) {
        CatalogView catalogView = new CatalogView();
        catalogView.setId(catalog.getId());
        catalogView.setName(catalog.getName());
        return catalogView;
    }

    public static List<CatalogView> fromCatalogList(List<Catalog> catalogs) {
        return catalogs
                .stream()
                .map(CatalogView::fromCatalog)
                .collect(Collectors.toList());
    }
}
