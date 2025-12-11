package com.sintrue.matrix.framework.example.service;

import org.springframework.stereotype.Service;

@Service
public class ExampleService implements IExampleService {
    @Override
    public String zeroParameter() {
        return "zero";
    }

    @Override
    public String oneParameter(String one) {
        return "one: " + one;
    }

    @Override
    public String twoParameter(String one, String two) {
        return "one: " + one + ", two: " + two;
    }

    @Override
    public String threeParameter(String one, String two, String three) {
        return "one: " + one + ", two: " + two + ", three: " + three;
    }

    @Override
    public void zeroVoid() {
        System.out.println("zeroVoid executed");
    }

    @Override
    public void oneVoid(String one) {
        System.out.println("oneVoid executed with: " + one);
    }

    @Override
    public void twoVoid(String one, String two) {
        System.out.println("twoVoid executed with: " + one + ", " + two);
    }
}
