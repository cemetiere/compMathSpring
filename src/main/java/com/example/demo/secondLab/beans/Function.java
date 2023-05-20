package com.example.demo.secondLab.beans;

public class Function {
    public double f(double x, int n){
        return switch (n){
            case 1 -> x*x-5*x-11;
            case 2 -> Math.sin(x+0.4);
            default -> throw new IllegalStateException("Unexpected value: " + n);
        };
    }
    public double getA(int n){
        return switch (n){
            case 1 -> -4;
            case 2 -> -1;
            default -> throw new IllegalStateException("Unexpected value: " + n);
        };
    }
    public double getB(int n){
        return switch (n){
            case 1 -> -1;
            case 2 -> -0.0001;
            default -> throw new IllegalStateException("Unexpected value: " + n);
        };
    }
    public java.util.function.Function<Double,Double> func(int n){
        return switch (n) {
            case 1 -> this::f1;
            case 2 -> this::f2;
            case 3 -> this::f3;
            default -> throw new UnsupportedOperationException("Function " + n + " not defined.");
        };
    }
    private double f1(double x){
        return 1/x;
    }
    private double f2(double x){
        return x*x-2;
    }
    private double f3(double x){
        return Math.sin(x)/x;
    }
}
