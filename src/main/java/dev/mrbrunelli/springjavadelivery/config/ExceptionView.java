package dev.mrbrunelli.springjavadelivery.config;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
public class ExceptionView {
    private LocalDateTime timestamp = LocalDateTime.now();
    private Integer status;
    private String error;
    private String message;
    private String path;

    public static ExceptionView make(HttpStatus hs, String message, HttpServletRequest req) {
        return ExceptionView.builder()
                .status(hs.value())
                .error(hs.name())
                .message(message)
                .path(req.getServletPath())
                .build();
    }
}
