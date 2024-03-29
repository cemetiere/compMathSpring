package com.example.demo.firstLab.beans;

public class Determinant {
    public double calculateDeterminantRecursively(double[][] A){
        double sum = 0;
        if (A.length==1){return A[0][0];}
        for(int i = 0; i < A[0].length; i++){
            sum += Math.pow(-1,i)*A[0][i]*calculateDeterminantRecursively(modifiedMatrix(A,i));
        }
        return sum;
    }
    public double[][] modifiedMatrix(double[][] A, int column){
        double[][] newA = new double[A.length-1][A[0].length-1];
        for(int i=1; i<A.length; i++){
            double[] row = new double[A[0].length-1];
            int a =0;
            for(int j=0; j<A[1].length; j++){
                if(j!=column){
                    row[a] = A[i][j];
                    a++;
                }
            }
            newA[i-1] = row;
        }
        return newA;
    }
    public double calculateDeterminant(double[][] A){
        double det = 1;
        for(int i=0; i<A.length; i++){
            det*=A[i][i];
        }
        return det;
    }
}
