package com.example.secondlab;

public class SecondFormula {
    public double result(double a, double b, double c, double d) {
        double result = 0;

        result = 2 * Math.sqrt((Math.sin(a) / Math.abs(Math.tan(b - a))) + (Math.log(c) / d));

        return result;
    }
}
