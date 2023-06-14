package dev.mrbrunelli.springjavadelivery.product;

import dev.mrbrunelli.springjavadelivery.catalog.Catalog;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer stock;
    private Boolean isFeatured;
    @ManyToMany
    @JoinTable(
            name = "catalog_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "catalog_id")
    )
    private List<Catalog> catalogs;
}
