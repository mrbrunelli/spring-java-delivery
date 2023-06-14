package dev.mrbrunelli.springjavadelivery.shared;

import dev.mrbrunelli.springjavadelivery.catalog.exception.CatalogNotFound;
import dev.mrbrunelli.springjavadelivery.product.exception.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionView handleServerError(Exception ex, HttpServletRequest req) {
        return ExceptionView.make(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), req);
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionView handleConflict(ConflictException ex, HttpServletRequest req) {
        return ExceptionView.make(HttpStatus.CONFLICT, ex.getMessage(), req);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionView handleBadRequest(MethodArgumentNotValidException ex, HttpServletRequest req) {
        HashMap<String, String> errorMessage = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(e -> errorMessage.put(e.getField(), e.getDefaultMessage()));
        return ExceptionView.make(HttpStatus.BAD_REQUEST, errorMessage.toString(), req);
    }

    @ExceptionHandler({CatalogNotFound.class, ProductNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionView handleNotFound(RuntimeException ex, HttpServletRequest req) {
        return ExceptionView.make(HttpStatus.NOT_FOUND, ex.getMessage(), req);
    }
}
