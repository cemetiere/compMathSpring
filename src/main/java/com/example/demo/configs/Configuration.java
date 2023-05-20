package com.example.demo.configs;

import com.example.demo.firstLab.beans.Determinant;
import com.example.demo.firstLab.beans.FileMatrixParser;
import com.example.demo.firstLab.beans.ResidualError;
import com.example.demo.firstLab.beans.GaussSolver;
import com.example.demo.secondLab.beans.*;
import com.example.demo.thirdLab.beans.Integral;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public GaussSolver getGaussSolver(){
        return new GaussSolver();
    }
    @Bean
    public Determinant getDeterminant(){
        return new Determinant();
    }
    @Bean
    public ResidualError getResidualError(){
        return new ResidualError();
    }
    @Bean
    public FileMatrixParser getFileMatrixParser(){
        return new FileMatrixParser();
    }
    @Bean
    public SecantMethod getSecantMethod(){
        return new SecantMethod(getFunction());
    }
    @Bean
    public Function getFunction(){
        return new Function();
    }
    @Bean
    public com.example.demo.thirdLab.utils.Function getFunction2(){
        return new com.example.demo.thirdLab.utils.Function();
    }
    @Bean
    public FixedPointIteration getFixedPointIteration(){
        return new FixedPointIteration();
    }
    @Bean
    public FixedPointSystem getFixedPointSystem(){
        return new FixedPointSystem();
    }
    @Bean
    public Integral getIntegral(){
        return  new Integral(getFunction2());
    }

}
