package dev.mrbrunelli.springjavadelivery.product.dto;

import dev.mrbrunelli.springjavadelivery.product.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ProductView {
    private Long id;
    private String name;
    private Double price;
    private Integer stock;
    private Boolean isFeatured;

    public static ProductView fromProduct(Product product) {
        ProductView productView = new ProductView();
        productView.setId(product.getId());
        productView.setName(product.getName());
        productView.setPrice(product.getPrice());
        productView.setStock(product.getStock());
        productView.setIsFeatured(product.getIsFeatured());
        return productView;
    }

    public static List<ProductView> fromProductList(List<Product> products) {
        return products
                .stream()
                .map(ProductView::fromProduct)
                .collect(Collectors.toList());
    }
}
