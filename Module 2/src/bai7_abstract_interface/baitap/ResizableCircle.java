package bai7_abstract_interface.baitap;

import bai6_kethua.baitap.Circle;

import java.util.Random;

public class ResizableCircle extends   implements Resize {
    public ResizableCircle() {
    }

    public ResizableCircle(double radius) {
        super(radius);
    }

    @Override
    public void resize(double percent) {
        Random generator = new Random(100);
        setRadius(getRadius() +getRadius()/100);
    }
}
