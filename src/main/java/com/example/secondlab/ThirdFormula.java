package com.example.secondlab;

public class ThirdFormula implements IFormula {
    @Override
    public double result(double a, double b, double c, double d) {
        double result = 0;

        result = Math.cos(b) + Math.sin(Math.sqrt(a));
        result /= 2 * Math.log10(c) + Math.exp(d);

        return result;
    }
}
