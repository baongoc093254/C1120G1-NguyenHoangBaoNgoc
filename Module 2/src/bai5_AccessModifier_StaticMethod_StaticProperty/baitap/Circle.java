package bai5_AccessModifier_StaticMethod_StaticProperty.baitap;

public class Circle {
    public double radius = 1.0;
    public String color = "red";


    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        return Math.PI*this.radius*this.radius;
    }
}
