package bai4_oop_class_object.thuchanh;

import java.util.Scanner;

public class ClassRectangle {
    double witdh;
    double height;
    public ClassRectangle() {

    }

    public ClassRectangle(double witdh, double height) {
        this.witdh = witdh;
        this.height = height;
    }

    public double getWitdh() {
        return witdh;
    }

    public void setWitdh(double witdh) {
        this.witdh = witdh;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public String display() {
        return "Rectangle" + "width" + this.witdh + "height" + this.height;
    }
    public  double getArea() {
        return this.witdh * this.height;
    }
    public double getPerimeter() {
        return (this.witdh + this.height) * 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width");
        double width = scanner.nextDouble();
        System.out.println("Enter height");
        double height = scanner.nextDouble();
        ClassRectangle hcn = new ClassRectangle();
        hcn.setHeight(height);
        hcn.setWitdh(width);
        System.out.println(hcn.display());
        System.out.println("Area " + hcn.getArea());
        System.out.println("Perimeter " + hcn.getPerimeter());
    }
}
