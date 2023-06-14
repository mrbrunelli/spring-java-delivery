package dev.mrbrunelli.springjavadelivery.catalog;

import dev.mrbrunelli.springjavadelivery.catalog.dto.CatalogView;
import dev.mrbrunelli.springjavadelivery.catalog.dto.NewCatalogDTO;
import dev.mrbrunelli.springjavadelivery.catalog.service.AddProductToCatalog;
import dev.mrbrunelli.springjavadelivery.catalog.service.SaveNewCatalog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {
    private final SaveNewCatalog saveNewCatalog;
    private final AddProductToCatalog addProductToCatalog;

    public CatalogController(SaveNewCatalog saveNewCatalog, AddProductToCatalog addProductToCatalog) {
        this.saveNewCatalog = saveNewCatalog;
        this.addProductToCatalog = addProductToCatalog;
    }

    @PostMapping
    public ResponseEntity<CatalogView> save(@Valid @RequestBody NewCatalogDTO dto) {
        CatalogView savedCatalog = saveNewCatalog.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCatalog);
    }

    @PutMapping("/{catalogId}/products/{productId}")
    public ResponseEntity<Void> addProductToCatalog(@PathVariable Long catalogId, @PathVariable Long productId) {
        addProductToCatalog.execute(catalogId, productId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
