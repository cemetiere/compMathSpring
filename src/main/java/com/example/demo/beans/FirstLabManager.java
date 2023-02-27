package com.example.demo.beans;

import com.example.demo.utils.FirstLabResponse;
import com.example.demo.utils.Matrix;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FirstLabManager {
    private final Determinant determinantSolver;
    private final GaussSolver gaussSolver;
    public FirstLabResponse solve(Matrix matrix) {
        double determinant = determinantSolver.calculateDeterminant(matrix.a());
        Matrix triangleMatrix = gaussSolver.forwardSubstitution(matrix);
        double[] answer = gaussSolver.backwardSubstitution(triangleMatrix);
        return new FirstLabResponse(determinant,null,null,1);
    }
}
