package dev.mrbrunelli.springjavadelivery.product;

import dev.mrbrunelli.springjavadelivery.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByIsFeaturedTrue();
}
