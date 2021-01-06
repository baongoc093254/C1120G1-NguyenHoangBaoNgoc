package bai3_array_java.thuchanh;

import java.util.Scanner;

public class TranformDegree {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;
        double celsius;
        double fahrenheit;
        do {
            System.out.println("Menu");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                System.out.println("1. Fahrenheit to Celcius");
                    System.out.println("Enter Fahrenheit: ");
                    fahrenheit = scanner.nextDouble();
                    System.out.println("Fahrenheit to Celcius " + fahrenheitToCelcius(fahrenheit));
                break;
                case 2:
                    System.out.println("2. Celsius to Fahrenheit");
                    System.out.println("Enter Celcius");
                    celsius = scanner.nextDouble();
                    System.out.println("Celcius to Fahrenheit " + celciusToFahrenheit(celsius));
                    break;
                case 3:
                    System.exit(0);
            }
        } while (choice !=0);

    }
    public static double celciusToFahrenheit(double celcius) {
        double fahrenheit = (9.0 / 5) * celcius + 32;
        return  fahrenheit;
    }
    public static double fahrenheitToCelcius (double fahrenheit) {
        double celcius = (5.0 / 9) * (fahrenheit - 32);
        return celcius;
    }
}
