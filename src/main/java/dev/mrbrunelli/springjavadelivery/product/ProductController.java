package dev.mrbrunelli.springjavadelivery.product;

import dev.mrbrunelli.springjavadelivery.product.service.GetProducts;
import dev.mrbrunelli.springjavadelivery.product.service.SaveNewProduct;
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
    private final SaveNewProduct saveNewProduct;
    private final GetProducts getProducts;

    public ProductController(SaveNewProduct saveNewProduct, GetProducts getProducts) {
        this.saveNewProduct = saveNewProduct;
        this.getProducts = getProducts;
    }

    @PostMapping
    public ResponseEntity<ProductView> save(@Valid @RequestBody NewProductDTO dto) {
        ProductView newProduct = saveNewProduct.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<ProductView>> getAll(@RequestParam(required = false) Boolean isFeatured) {
        if (isFeatured == null) {
            isFeatured = false;
        }
        List<ProductView> products = getProducts.execute(isFeatured);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
