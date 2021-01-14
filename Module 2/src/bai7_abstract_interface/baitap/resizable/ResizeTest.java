package bai7_abstract_interface.baitap.resizable;

import bai6_kethua.thuchanh.Shape;
import bai7_abstract_interface.baitap.resizable.ResizableCircle;
import bai7_abstract_interface.baitap.resizable.ResizableRectangle;
import bai7_abstract_interface.baitap.resizable.ResizableSquare;

import java.util.Random;

public class ResizeTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new ResizableSquare(5);
        shapes[1] = new ResizableRectangle(2.0, 5.0);
        shapes[2] = new ResizableCircle(5.0);
        Random generator = new Random();



        for (Shape shape: shapes) {
            System.out.println("Before\n");
            int percent = generator.nextInt(99)+1;
            if (shape instanceof ResizableRectangle) {
                System.out.println("Old Length: "+ ((ResizableRectangle) shape).getLength());
                System.out.println("Old width" +((ResizableRectangle) shape).getWidth());
                System.out.println("Old Area:" +((ResizableRectangle) shape).getArea());
        }else if (shape instanceof ResizableCircle) {
                System.out.println("Old Radius: " + ((ResizableCircle) shape).getRadius());
                System.out.println("Old Area: " + ((ResizableCircle) shape).getArea());
            } else if (shape instanceof ResizableSquare){
                System.out.println("Old side: " + ((ResizableSquare) shape).getSide());
                System.out.println("Old Area: " + ((ResizableSquare) shape).getArea());
            }
            System.out.println("Percent : " + percent + " %");
            System.out.println("After resize : ");
            if (shape instanceof ResizableRectangle) {
                ((ResizableRectangle) shape).reSize(percent);
                System.out.println("New Length : " + ((ResizableRectangle) shape).getLength());
                System.out.println("New Width : " + ((ResizableRectangle) shape).getWidth());
                System.out.println("New area : " + ((ResizableRectangle) shape).getArea());
            } else if (shape instanceof ResizableSquare) {
                ((ResizableSquare) shape).reSize(percent);
                System.out.println("New size : " + ((ResizableSquare) shape).getSide());
                System.out.println("New area : " + ((ResizableSquare) shape).getArea());
            } else if (shape instanceof ResizableCircle) {
                ((ResizableCircle) shape).reSize(percent);
                System.out.println("New radius : " + ((ResizableCircle) shape).getRadius());
                System.out.println("New perimeter : " + ((ResizableCircle) shape).getPerimeter());
            }
        }

    }
}





