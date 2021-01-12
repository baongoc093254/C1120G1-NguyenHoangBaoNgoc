package bai7_abstract_interface.baitap;

import bai6_kethua.thuchanh.Circle;

import java.util.Random;

public class ResizableCircle extends Circle implements Resize {
    public ResizableCircle() {
    }

    public ResizableCircle(double radius) {
        super(radius);
    }

    @Override
    public void resize(double percent) {
        this.setRadius(getRadius() +getRadius()/100);
    }
}
