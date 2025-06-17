package ru.netolgy.ExceptionGlobal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.netolgy.Exception.InvalidCredentials;
import ru.netolgy.Exception.UnauthorizedUser;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Обработка пустых учетных данных
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentials ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // 400
                .body(ex.getMessage());
    }

    // Обработка неавторизованного доступа
    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleUnauthorizedUser(UnauthorizedUser ex) {
        System.out.println("Unauthorized access attempt: " + ex.getMessage()); // Лог в консоль
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED) // 401
                .body(ex.getMessage());
    }
}
