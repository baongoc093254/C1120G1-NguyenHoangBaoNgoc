package bai4_oop_class_object.baitap;

import javafx.scene.paint.Stop;

import java.util.Scanner;

public class Fan {
    private int speed;
    private final String SLOW = "SLOW";
    private final String MEDIUM = "MEDIUM";
    private final String FAST = "FAST";
    private double radius = 5.0;
    private String color = "blue";
    private boolean on = false;

    public Fan(int speed, double radius, String color, boolean on) {
        this.speed = speed;
        this.radius = radius;
        this.color = color;
        this.on = on;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public Fan() {
    }

    public String toString() {
        String speeds = "";
        switch (speed) {
            case 1:
                speeds = SLOW;
                break;
            case 2:
                speeds = MEDIUM;
                break;
            case 3:
                speeds = FAST;
                break;
            default:
                break;
        }
        if (on) {
            return   this.radius + " " + this.color + " " + " Fan is off";
        } else {
            return speeds + " " + this.radius + " " + this.color + " " + "Fan is on";
        }
    }

    public static void main(String[] args) {
        Fan fan1 = new Fan(3, 10, "yellow", true);
        Fan fan2 = new Fan(2,5,"blue",false);
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
