package dev.mrbrunelli.springjavadelivery.catalog.dto;

import dev.mrbrunelli.springjavadelivery.catalog.Catalog;
import dev.mrbrunelli.springjavadelivery.product.dto.ProductView;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
}
