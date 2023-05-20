package com.example.demo.utils;

import com.example.demo.firstLab.exceptions.MatrixIsNotSquareException;
import com.example.demo.firstLab.exceptions.ZeroDeterminantException;
import com.example.demo.thirdLab.exceptions.IntegralDoesNotExist;
import com.example.demo.thirdLab.exceptions.UnknownFunction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class Advisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MatrixIsNotSquareException.class)
    public ResponseEntity<?> handleIsNotSquare(MatrixIsNotSquareException e) {
        return ResponseEntity.badRequest().body("The number of rows is not equal to the number of columns");
    }
    @ExceptionHandler(ZeroDeterminantException.class)
    public ResponseEntity<?> handleZeroDeterminant(ZeroDeterminantException e) {
        return ResponseEntity.badRequest().body("Zero determinant! Matrix can't be solved");
    }
    @ExceptionHandler(IntegralDoesNotExist.class)
    public ResponseEntity<?> integralDoesNotExist(IntegralDoesNotExist e) {
        return ResponseEntity.badRequest().body("Integrated function has discontinuity or does not defined in current interval");
    }
    @ExceptionHandler(UnknownFunction.class)
    public ResponseEntity<?> unknownFunction(UnknownFunction e) {
        return ResponseEntity.badRequest().body("Unknown function. Please, choose one of the suggested");
    }
}
