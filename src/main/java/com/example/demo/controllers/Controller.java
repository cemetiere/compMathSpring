package com.example.demo.controllers;

import com.example.demo.firstLab.beans.Determinant;
import com.example.demo.firstLab.beans.FileMatrixParser;
import com.example.demo.firstLab.beans.ResidualError;
import com.example.demo.firstLab.beans.GaussSolver;
import com.example.demo.firstLab.exceptions.MatrixIsNotSquareException;
import com.example.demo.firstLab.exceptions.ZeroDeterminantException;
import com.example.demo.firstLab.utils.Matrix;
import com.example.demo.secondLab.beans.FixedPointIteration;
import com.example.demo.secondLab.beans.FixedPointSystem;
import com.example.demo.secondLab.beans.SecantMethod;
import com.example.demo.secondLab.utils.SecondLabRequest;
import com.example.demo.thirdLab.beans.Integral;
import com.example.demo.thirdLab.exceptions.IntegralDoesNotExist;
import com.example.demo.thirdLab.exceptions.UnknownFunction;
import com.example.demo.thirdLab.utils.ThirdLabRequest;
import com.example.demo.utils.FirstLabResponse;
import com.example.demo.utils.SecondLabNonlinearResponse;
import com.example.demo.utils.SecondLabResponse;
import com.example.demo.utils.SecondLabSysResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/compMath")
@RequiredArgsConstructor
public class Controller {
    private final Determinant determinantSolver;
    private final GaussSolver gaussSolver;
    private final ResidualError residualErrorSolver;
    private final FileMatrixParser matrixParser;
    private final SecantMethod secantMethod;
    private final FixedPointIteration fixedPointIteration;
    private final FixedPointSystem fixedPointSystem;
    private final Integral integral;

    @PostMapping ("calculateMatrix")
    public FirstLabResponse calculateMatrix(@RequestBody Matrix matrix) throws MatrixIsNotSquareException, ZeroDeterminantException {
        if(matrix.b().length != matrix.a()[0].length){
            throw new MatrixIsNotSquareException();
        }
        Matrix triangleMatrix = gaussSolver.forwardSubstitution(matrix);
        double determinant = determinantSolver.calculateDeterminant(triangleMatrix.a());
        System.out.println(determinant);
        if(determinant==0 || Double.isNaN(determinant)){
            throw new ZeroDeterminantException();
        }
        double[] answer = gaussSolver.backwardSubstitution(triangleMatrix);
        double[] discrepancy = residualErrorSolver.calculateResidualError(matrix, answer);
        return new FirstLabResponse(determinant,triangleMatrix,answer,discrepancy);
    }

    @PostMapping("calculateFileMatrix")
    public FirstLabResponse calculateFileMatrix(@RequestBody MultipartFile file) throws IOException, ZeroDeterminantException, MatrixIsNotSquareException {
        Matrix matrix = matrixParser.parseMatrix(file);
        return calculateMatrix(matrix);
    }
    @PostMapping("calculateNonlinearEquation")
    public SecondLabResponse calculateNonlinearEquation(@RequestBody SecondLabRequest request) throws Exception {
        double first;
        double second;
        double difference;
        double[] system;
        if (request.n()==1||request.n()==2){
            first = secantMethod.solve(request.n());
            second = fixedPointIteration.solve(request.n());
            difference = Math.abs(second-first);
            return new SecondLabNonlinearResponse(first, second, difference);
        } else if (request.n()==3||request.n()==4){
            system = fixedPointSystem.solve(request.n());
            return  new SecondLabSysResponse(system);
        }
        throw new IllegalStateException("Unexpected value: " + request.n());
    }
    @PostMapping("calculateIntegral")
    public double[] calculateIntegral(@RequestBody ThirdLabRequest request) throws IntegralDoesNotExist, UnknownFunction {
        if(request.f()!=1 && request.f()!=2 && request.f()!=3){
            throw new UnknownFunction();
        }
        double[] res = integral.calculate_integral(request.a(), request.b(), request.f(), request.eps());
        if (res == null){
            throw new IntegralDoesNotExist();
        }
        return res;
    }
}
