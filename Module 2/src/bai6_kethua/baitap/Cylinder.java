package bai6_kethua.baitap;

public class Cylinder extends Circle  {
    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    public void setRadius(double radius) {
        super.setRadius(radius);
    }


    public void setColor(String color) {
        super.setColor(color);
    }
    public double getAreaa() {
        return 2*Math.PI*getRadius()*(getHeight()+getRadius());
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(15.0);
        cylinder.setColor("red");
        cylinder.setRadius(2.0);
        System.out.println("Are hình trụ" + cylinder.getAreaa() + " " + cylinder.getColor() + " " + cylinder.getHeight() + cylinder.getRadius());
    }

}



