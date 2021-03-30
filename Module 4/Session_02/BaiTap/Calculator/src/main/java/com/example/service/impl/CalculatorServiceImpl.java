package com.example.service.impl;

import com.example.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public float calculate(String firstNumber, String secondNumber, String operator) {
        float first = Float.parseFloat(firstNumber);
        float second = Float.parseFloat(secondNumber);
        float result = 0;


        switch (operator) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                result = first / second;
                break;
            default:
                break;

        }

        return  result;
    }
}
