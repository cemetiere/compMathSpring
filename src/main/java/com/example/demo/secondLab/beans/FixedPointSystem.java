package com.example.demo.secondLab.beans;

public class FixedPointSystem {
    private static final double EPSILON = 0.0001;

    public double[] solve(int n) {

        double x = 0.5;
        double y = 0.5;
        double prevX = 0;
        double prevY = 0;
        while(Math.abs(x - prevX) > EPSILON && Math.abs(y - prevY) > EPSILON){
            prevX = x;
            prevY = y;
            x = f1(prevY, n);
            y = f2(prevX, n);
        }

        return new double[]{x, y};
    }

    private double f1(double y, int n) {
        return switch (n){
            case 3 -> Math.sqrt(1-y*y);
            case 4 -> -Math.sin(y)-0.4;
            default -> throw new IllegalStateException("Unexpected value: " + n);
        };
    }

    private static double f2(double x, int n){
        return switch (n){
            case 3 -> (-Math.log(x)-1)/2;
            case 4 -> 0.5*Math.cos(x+1);
            default -> throw new IllegalStateException("Unexpected value: " + n);
        };
    }
}


