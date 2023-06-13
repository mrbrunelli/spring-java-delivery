package dev.mrbrunelli.springjavadelivery.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final SaveNewProductService saveNewProductService;
    private final ProductRepository repository;

    public ProductController(SaveNewProductService saveNewProductService, ProductRepository repository) {
        this.saveNewProductService = saveNewProductService;
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody SaveNewProductDTO dto) {
        Product newProduct = saveNewProductService.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/featured")
    public ResponseEntity<List<Product>> getAllFeatured() {
        List<Product> products = repository.findByIsFeaturedTrue();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
