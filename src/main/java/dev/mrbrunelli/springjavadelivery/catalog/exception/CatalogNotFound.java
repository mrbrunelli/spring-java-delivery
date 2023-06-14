package dev.mrbrunelli.springjavadelivery.catalog.exception;

public class CatalogNotFound extends RuntimeException {

    public CatalogNotFound() {
        super("catalog not found");
    }

    public CatalogNotFound(String message) {
        super(message);
    }
}
