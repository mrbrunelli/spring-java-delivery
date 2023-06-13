package dev.mrbrunelli.springjavadelivery.product;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class NewProductDTO {
    @NotNull
    private String name;

    @NotNull
    @Positive
    private Double price;

    @NotNull
    @Positive
    private Integer stock;

    private Boolean isFeatured = false;

    public Product toProduct() {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        product.setIsFeatured(isFeatured);
        return product;
    }
}
