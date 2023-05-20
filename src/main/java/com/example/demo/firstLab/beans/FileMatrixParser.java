package com.example.demo.firstLab.beans;

import com.example.demo.firstLab.utils.Matrix;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class FileMatrixParser {
    public Matrix parseMatrix(MultipartFile file) throws IOException {
        String input = new String(file.getBytes());
        String[] strings = input.split("\n");

        int dim = strings.length/2;
        double[][] a = new double[dim][dim];
        double[] b  = new double[dim];
        for(int i=0; i<dim; i++){
            String[] str = strings[i].split(" ");
            for(int j = 0; j<str.length; j++){
                a[i][j] = Double.parseDouble(str[j]);
            }
        }
        for(int i = dim; i<strings.length; i++){
            b[i-dim] = Double.parseDouble(strings[i]);
        }

        return new Matrix(a, b);
    }
}
