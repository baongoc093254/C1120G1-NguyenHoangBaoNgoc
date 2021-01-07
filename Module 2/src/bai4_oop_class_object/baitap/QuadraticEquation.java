package bai4_oop_class_object.baitap;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
    public double getDiscriminant() {
        double delta;
        return delta = this.b*this.b - 4*this.a*this.c;
    }
    public double getRoot1() {
        double r1;
        return r1 = (-this.b + Math.sqrt(this.b*this.b - 4*this.a*this.c))/ 2*this.a;
    }
    public double getRoot2() {
        double r2;
        return r2 =(-this.b - Math.sqrt(this.b*this.b - 4*this.a*this.c))/ 2*this.a;

    }
    public double getRoot3() {
        double r3;
        return r3 = (-this.b) / 2*this.a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a: ");
        double a = scanner.nextDouble();
        System.out.println("Enter b: ");
        double b = scanner.nextDouble();
        System.out.println("Enter c: ");
        double c = scanner.nextDouble();
        QuadraticEquation result = new QuadraticEquation(a,b,c);
        result.setA(a);
        result.setB(b);
        result.setC(c);
        if (result.getDiscriminant() <0) {
            System.out.println("Phương trình vô nghiệm");
        } else if (result.getDiscriminant() == 0){
            System.out.println("Phương trình có nghiệm kép r1 = r2 = " + result.getRoot3());

        } else {
            System.out.println("Phương trình có 2 nghiệm: " + "r1 = " + result.getRoot1() + "\t" + " r2 = " + result.getRoot2());
        }
    }
}
