package com.example.demo.utils;

import com.example.demo.exceptions.MatrixIsNotSquareException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Advisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MatrixIsNotSquareException.class)
    public ResponseEntity<?> handleIncorrectUsername(MatrixIsNotSquareException e) {
        return ResponseEntity.badRequest().body("The number of rows is not equal to the number of columns");
    }
}
