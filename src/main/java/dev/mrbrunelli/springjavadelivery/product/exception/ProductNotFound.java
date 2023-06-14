package dev.mrbrunelli.springjavadelivery.product.exception;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound() {
        super("product not found");
    }

    public ProductNotFound(String message) {
        super(message);
    }
}
