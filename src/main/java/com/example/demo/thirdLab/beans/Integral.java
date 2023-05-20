package com.example.demo.secondLab.beans;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Integral {
    private Function function;
    public double calculate_integral(double a, double b, int f, double epsilon) {
        java.util.function.Function<Double, Double> func = function.func(f);
        if(epsilon==0){
            error_message = "Integrated function has discontinuity or does not defined in current interval";
            has_discontinuity=true;
            return 0;
        }
        double answer = 0;
        boolean m = false;
        if(a>b){
            double tmp = a;
            a=b;
            b=tmp;
            m = true;
        }
        while(a<b){
            answer += epsilon*func.apply(a);
            a+= epsilon;
            if(f==1){
                a = Math.round(a/epsilon)*epsilon;
            }
        }

        return m == true ? answer*-1 : answer;
    }
}

