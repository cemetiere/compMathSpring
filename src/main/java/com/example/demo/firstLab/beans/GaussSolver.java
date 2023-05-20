package com.example.demo.beans;

import com.example.demo.utils.Matrix;

public class GaussSolver {
    public Matrix forwardSubstitution(Matrix matrix){
        double[][] A = matrix.a();
        double[] b = matrix.b();
        int n = b.length;
        for (int k = 0; k < n; k++) {
            int maxIndex = k;
            double max = A[k][k];
            for (int i = k + 1; i < n; i++) {
                if (Math.abs(A[i][k]) > Math.abs(max)) {
                    max = A[i][k];
                    maxIndex = i;
                }
            }
            if (maxIndex != k) {
                double[] temp = A[k];
                A[k] = A[maxIndex];
                A[maxIndex] = temp;
                double t = b[k];
                b[k] = b[maxIndex];
                b[maxIndex] = t;
            }
            for (int i = k + 1; i < n; i++) {
                double c = A[i][k] / A[k][k];
                b[i] -= c * b[k];
                for (int j = k; j < n; j++) {
                    A[i][j] -= c * A[k][j];
                }
            }
        }

        return new Matrix(A, b);
    }
    public double[] backwardSubstitution(Matrix matrix){
        double[][] A = matrix.a();
        double[] b = matrix.b();
        int n = b.length;
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }
}
