package dev.mrbrunelli.springjavadelivery.catalog;

import dev.mrbrunelli.springjavadelivery.catalog.dto.CatalogView;
import dev.mrbrunelli.springjavadelivery.catalog.dto.NewCatalogDTO;
import dev.mrbrunelli.springjavadelivery.catalog.service.SaveNewCatalog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {
    private final SaveNewCatalog saveNewCatalog;

    public CatalogController(SaveNewCatalog saveNewCatalog) {
        this.saveNewCatalog = saveNewCatalog;
    }

    @PostMapping
    public ResponseEntity<CatalogView> save(@Valid @RequestBody NewCatalogDTO dto) {
        CatalogView savedCatalog = saveNewCatalog.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCatalog);
    }
}
