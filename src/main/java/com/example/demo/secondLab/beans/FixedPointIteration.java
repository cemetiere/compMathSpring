package com.example.demo.secondLab.beans;


public class FixedPointIteration {
    private static final double EPS = 1e-5;
    private static final double X0 = 1;
    public double solve(int n){
        double x= X0;
        while (Math.abs(phi(x,n)-x)>EPS){
            x = phi(x,n);
            System.out.println(x);
        }
        return x;
    }
    public double phi(double x, int n){
        return switch (n){
            case 1 -> (x*x-11)/5;
            case 2 -> -Math.sin(x+0.4)+x;
            default -> throw new IllegalStateException("Unexpected value: " + n);
        };
    }


}
