package com.example.demo.firstLab.beans;

import com.example.demo.firstLab.utils.Matrix;

public class ResidualError {
    public double[] calculateResidualError(Matrix matrix, double[] answer){
        double[][] a = matrix.a();
        double[] b = matrix.b();
        double[] x = new double[matrix.b().length];
        for(int i = 0; i<a.length; i++){
            double sum = 0;
            for (int j = 0; j<a.length; j++){
                sum += a[i][j]*answer[j];

            }
            x[i] = sum - b[i];
        }
        return x;
    }
}
