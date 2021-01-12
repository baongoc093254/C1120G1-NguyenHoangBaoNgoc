package bai7_abstract_interface.baitap.resizable;

import bai6_kethua.thuchanh.Shape;
import bai7_abstract_interface.baitap.resizable.ResizableCircle;
import bai7_abstract_interface.baitap.resizable.ResizableRectangle;
import bai7_abstract_interface.baitap.resizable.ResizableSquare;

import java.util.Random;

public class ResizeTest  {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new ResizableSquare(5);
        shapes[1] = new ResizableRectangle(2.0,5.0);
        shapes[2] = new ResizableCircle(5.0);
        Random generator = new Random();
        ResizableShape resizableShape = null;

        System.out.println("Before");
        for (Shape shape: shapes) {
            int percent = generator.nextInt(99) +1;



        }


    }
}
