package Model;

import java.io.IOException;

public class Calculator {
    public static float calculate(float firstNumber, float secondNumber, char operator) {
        switch (operator) {
            case '+':
                return firstNumber + secondNumber;

            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                if (secondNumber != 0) {
                    return firstNumber / secondNumber;
                } else {
                    throw new RuntimeException("Cant divide zero !");
                }
            default:
                throw new RuntimeException("Not valid value !");
        }
    }
}
