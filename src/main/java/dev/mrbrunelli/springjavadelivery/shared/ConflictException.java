package dev.mrbrunelli.springjavadelivery.shared;

public class ConflictException extends RuntimeException {
    public ConflictException() {
        super("conflict");
    }

    public ConflictException(String message) {
        super(message);
    }
}
