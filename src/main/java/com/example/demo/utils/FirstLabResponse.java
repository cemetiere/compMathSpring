package com.example.demo.utils;

import com.example.demo.firstLab.utils.Matrix;

public record FirstLabResponse(double determinant, Matrix triangularMatrix, double[] answer, double[] discrepancy) {
}
