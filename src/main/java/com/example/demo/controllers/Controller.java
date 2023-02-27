package com.example.demo.controllers;

import com.example.demo.beans.FirstLabManager;
import com.example.demo.beans.GaussSolver;
import com.example.demo.exceptions.MatrixIsNotSquareException;
import com.example.demo.utils.Matrix;
import com.example.demo.utils.FirstLabResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compMath")
@RequiredArgsConstructor
public class Controller {
    private final FirstLabManager firstLab;

    @PostMapping ("calculateMatrix")
    public FirstLabResponse calculateMatrix(@RequestBody Matrix matrix) throws MatrixIsNotSquareException {
        if(matrix.b().length != matrix.a()[0].length){
            throw new MatrixIsNotSquareException();
        }
        return firstLab.solve(matrix);
    }
}
