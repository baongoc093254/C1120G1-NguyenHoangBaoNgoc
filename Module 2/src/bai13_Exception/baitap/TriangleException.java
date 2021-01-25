package bai13_Exception.baitap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TriangleException {
    private static int[] testTriangle() throws TriangleCheckingException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 3 sides of triangle !");
        int sideA;
        int sideB;
        int sideC;
        try {
            System.out.println("Enter side A");
            sideA = scanner.nextInt();
            System.out.println("Enter side B");
            sideB = scanner.nextInt();
            System.out.println("Enter side C");
            sideC = scanner.nextInt();
            if (sideA < 0 || sideB < 0 || sideC < 0) {
                throw new TriangleCheckingException("Three sides of the triangle not less than 0  !");
            }
            if ((sideA + sideB) < sideC || (sideB + sideC) < sideA || (sideA + sideC) < sideB) {
                throw new TriangleCheckingException("Addtion of 2 side of triangle less than other !");
            }
        } catch (InputMismatchException e) {
            throw new TriangleCheckingException("Three side of triangle is a number !");
        }
        return new int[]{sideA, sideB, sideC};
    }

    public static void main(String[] args) {
        try {
            int[] sides = testTriangle();
            System.out.println("Three side of triangle are :");
            for (int i :sides) {
                System.out.print(i + "\t");
            }
        } catch (TriangleCheckingException e) {
            System.out.println(e.getMessage());
        }
    }
}
