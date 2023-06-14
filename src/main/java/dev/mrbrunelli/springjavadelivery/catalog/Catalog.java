package dev.mrbrunelli.springjavadelivery.catalog;

import dev.mrbrunelli.springjavadelivery.product.Product;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "catalogs")
    private List<Product> products;
}
