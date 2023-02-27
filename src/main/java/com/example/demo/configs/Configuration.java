package com.example.demo.configs;

import com.example.demo.beans.Determinant;
import com.example.demo.beans.FirstLabManager;
import com.example.demo.beans.GaussSolver;
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
    public FirstLabManager getFirstLab(){
        return new FirstLabManager(getDeterminant(), getGaussSolver());
    }
}
