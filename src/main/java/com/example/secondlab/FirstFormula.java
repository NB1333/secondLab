package com.example.secondlab;

public class FirstFormula implements IFormula {
    @Override
    public double result(double a, double b, double c, double d) {
        double result = 0;

        result = Math.pow(Math.tan(a), (1 / c));
        result /= 1 + Math.sinh(b) / Math.log(Math.abs(d + c));

        return result;
    }
}
