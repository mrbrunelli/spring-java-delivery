package dev.mrbrunelli.springjavadelivery.repository;

import dev.mrbrunelli.springjavadelivery.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
