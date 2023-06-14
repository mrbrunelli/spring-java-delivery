package dev.mrbrunelli.springjavadelivery.product;

import dev.mrbrunelli.springjavadelivery.product.service.GetProductsService;
import dev.mrbrunelli.springjavadelivery.product.service.SaveNewProductService;
import dev.mrbrunelli.springjavadelivery.product.dto.NewProductDTO;
import dev.mrbrunelli.springjavadelivery.product.dto.ProductView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final SaveNewProductService saveNewProductService;
    private final GetProductsService getProductsService;

    public ProductController(SaveNewProductService saveNewProductService, GetProductsService getProductsService) {
        this.saveNewProductService = saveNewProductService;
        this.getProductsService = getProductsService;
    }

    @PostMapping
    public ResponseEntity<ProductView> create(@Valid @RequestBody NewProductDTO dto) {
        ProductView newProduct = saveNewProductService.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<ProductView>> getAll(@RequestParam(required = false) Boolean isFeatured) {
        List<ProductView> products = getProductsService.execute(isFeatured);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
