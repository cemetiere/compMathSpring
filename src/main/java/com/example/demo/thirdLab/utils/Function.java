package com.example.demo.thirdLab.utils;

public class Function {

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
        return Math.log(x);
    }
}
