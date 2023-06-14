package dev.mrbrunelli.springjavadelivery.catalog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {
}
