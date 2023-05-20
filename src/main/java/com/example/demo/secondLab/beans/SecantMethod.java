package com.example.demo.secondLab.beans;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public class SecantMethod {
    private final Function function;

    private static final double EPS = 1e-5;
    public double solve(int n){
        double next = 0;
        double curr = function.getB(n);
        double prev = function.getA(n);
        double tmp;
        while (Math.abs(next-curr)>EPS){
            tmp = next;
            next = curr - function.f(curr,n)*(prev-curr)/(function.f(prev,n)-function.f(curr,n));
            prev = curr;
            curr = tmp;
        }
        return next;
    }
}
