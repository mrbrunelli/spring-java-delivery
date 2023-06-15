package dev.mrbrunelli.springjavadelivery.catalog.dto;

import dev.mrbrunelli.springjavadelivery.catalog.Catalog;
import dev.mrbrunelli.springjavadelivery.product.dto.ProductView;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class CatalogWithProductsView {
    private Long id;
    private String name;
    private List<ProductView> products = new ArrayList<>();

    public static CatalogWithProductsView fromCatalog(Catalog catalog) {
        CatalogWithProductsView catalogWithProductsView = new CatalogWithProductsView();
        catalogWithProductsView.setId(catalog.getId());
        catalogWithProductsView.setName(catalog.getName());
        catalog.getProducts()
                .forEach(product -> catalogWithProductsView.getProducts().add(ProductView.fromProduct(product)));
        return catalogWithProductsView;
    }

    public static List<CatalogWithProductsView> fromCatalogList(List<Catalog> catalogs) {
        return catalogs.stream()
                .map(CatalogWithProductsView::fromCatalog)
                .collect(Collectors.toList());
    }
}
