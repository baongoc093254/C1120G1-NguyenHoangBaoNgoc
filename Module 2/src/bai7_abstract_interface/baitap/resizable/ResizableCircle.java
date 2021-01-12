package bai7_abstract_interface.baitap.resizable;

import bai6_kethua.thuchanh.Circle;

public class ResizableCircle extends Circle implements Resize {
    public ResizableCircle() {
    }

    public ResizableCircle(double radius) {
        super(radius);
    }

    @Override
    public void reSize(double percent) {
        this.setRadius(super.getRadius() + super.getRadius()/100);
    }
}
