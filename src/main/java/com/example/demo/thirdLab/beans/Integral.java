package com.example.demo.thirdLab.beans;

import com.example.demo.thirdLab.utils.Function;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Integral {
    private final Function functions;
    public double[] calculate_integral(double a, double b, int f, double epsilon) {
        java.util.function.Function<Double, Double> func = functions.func(f);
        if(epsilon==0){
            return null;
        }
        double[] answer = {0,0,0};
        boolean m = false;
        if(a>b){
            double tmp = a;
            a=b;
            b=tmp;
            m = true;
        }

        while(a<b){

            answer[0] += epsilon*func.apply(a);
            answer[1] += epsilon*func.apply(a+epsilon);
            answer[2] += epsilon*func.apply(a+epsilon/2);
            if(Double.isInfinite(answer[0])||Double.isNaN(answer[0])){
                return null;
            }
            a+= epsilon;
            a = Math.round(a*(1/epsilon))*epsilon;
        }
        if(m){
            for (int i=0; i<3; i++){
                answer[i]=answer[i]*-1;
            }
        }

        return answer;
    }
}

