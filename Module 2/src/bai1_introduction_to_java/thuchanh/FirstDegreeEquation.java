package bai1_introduction_to_java.thuchanh;

import java.util.Scanner;

public class FirstDegreeEquation {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = 0'");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập a: ");
        float a = scanner.nextInt();
        System.out.print("Nhập b: ");
        float b = scanner.nextInt();
        if (a != 0) {
            float x =  - b / a;
            System.out.print("x có giá trị " + x);
        } else if (b == 0) {
            System.out.print("Phương trình có vô số nghiệm x");
        } else {
            System.out.print("Phương trình vô nghiệm");
        }
    }
}

