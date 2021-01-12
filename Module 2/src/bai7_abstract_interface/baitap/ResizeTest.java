package bai7_abstract_interface.baitap;

import bai6_kethua.thuchanh.Circle;
import bai6_kethua.thuchanh.Shape;
import java.util.Random;

public class ResizeTest  {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new ResizableSquare(5);
        shapes[1] = new ResizableRectangle(2.0,5.0);
        shapes[2] = new ResizableCircle(5.0);
        System.out.println("Before");
        for (Shape shape: shapes) {
            System.out.println(shape.getArea());
        }
        System.out.println("After");


    }
}
