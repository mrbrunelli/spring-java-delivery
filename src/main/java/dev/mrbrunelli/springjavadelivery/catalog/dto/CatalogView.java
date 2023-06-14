package dev.mrbrunelli.springjavadelivery.catalog.dto;

import dev.mrbrunelli.springjavadelivery.product.Product;
import dev.mrbrunelli.springjavadelivery.product.dto.ProductView;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CatalogView {
    private Long id;
    private String name;

    public static ProductView fromProduct(Product product) {
        ProductView productView = new ProductView();
        productView.setId(product.getId());
        productView.setName(product.getName());
        return productView;
    }

    public static List<ProductView> fromProductList(List<Product> products) {
        return products
                .stream()
                .map(CatalogView::fromProduct)
                .collect(Collectors.toList());
    }
}
