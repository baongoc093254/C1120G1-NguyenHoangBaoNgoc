package bai6_kethua.baitap;

public class Circle {
    private  double radius;
    private  String color;
    private boolean fille;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }


    public Circle(double radius, String color,boolean fille) {
        this.radius = radius;
        this.color = color;
        this.fille = fille;
    }

    public Circle(double v, String blue) {
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
        return this.radius*this.radius*Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
class DisplayCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(12.0,"blue");
        System.out.println(circle);
    }
        }

