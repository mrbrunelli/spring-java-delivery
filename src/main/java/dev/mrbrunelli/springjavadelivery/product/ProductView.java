package dev.mrbrunelli.springjavadelivery.product;

import lombok.Data;
import lombok.NoArgsConstructor;

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
}
