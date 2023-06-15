package dev.mrbrunelli.springjavadelivery.catalog;

import dev.mrbrunelli.springjavadelivery.catalog.dto.CatalogView;
import dev.mrbrunelli.springjavadelivery.catalog.dto.CatalogWithProductsView;
import dev.mrbrunelli.springjavadelivery.catalog.dto.NewCatalogDTO;
import dev.mrbrunelli.springjavadelivery.catalog.service.AddProductToCatalog;
import dev.mrbrunelli.springjavadelivery.catalog.service.GetCatalogById;
import dev.mrbrunelli.springjavadelivery.catalog.service.GetCatalogs;
import dev.mrbrunelli.springjavadelivery.catalog.service.SaveNewCatalog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/catalogs")
public class CatalogController {
    private final SaveNewCatalog saveNewCatalog;
    private final AddProductToCatalog addProductToCatalog;
    private final GetCatalogById getCatalogById;
    private final GetCatalogs getCatalogs;

    public CatalogController(SaveNewCatalog saveNewCatalog, AddProductToCatalog addProductToCatalog, GetCatalogById getCatalogById, GetCatalogs getCatalogs) {
        this.saveNewCatalog = saveNewCatalog;
        this.addProductToCatalog = addProductToCatalog;
        this.getCatalogById = getCatalogById;
        this.getCatalogs = getCatalogs;
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

    @GetMapping("/{id}")
    public ResponseEntity<CatalogWithProductsView> getById(@PathVariable Long id) {
        CatalogWithProductsView catalogView = getCatalogById.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(catalogView);
    }

    @GetMapping
    public ResponseEntity<List<CatalogWithProductsView>> getAll() {
        List<CatalogWithProductsView> catalogs = getCatalogs.execute();
        return ResponseEntity.status(HttpStatus.OK).body(catalogs);
    }
}
