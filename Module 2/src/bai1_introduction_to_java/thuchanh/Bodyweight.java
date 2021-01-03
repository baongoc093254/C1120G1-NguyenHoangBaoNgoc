package bai1_introduction_to_java.thuchanh;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Bodyweight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập chiều cao và cân nặng của bạn: ");
        System.out.println("Nhập cân nặng của bạn (Kg) :");
        double weight = scanner.nextDouble();
        System.out.println("Nhập chiều cao của bạn (m):");
        double height = scanner.nextDouble();
        double bmi = weight / Math.pow(height,2);
        if (bmi < 18.5) {
            System.out.println("Underweight.");
        } else if (bmi < 25.0) {
            System.out.println("Normal.");
        } else if (bmi <= 30.0) {
            System.out.println("Oberweight.");
        } else {
            System.out.println("Obese.");
        }
    }
}
