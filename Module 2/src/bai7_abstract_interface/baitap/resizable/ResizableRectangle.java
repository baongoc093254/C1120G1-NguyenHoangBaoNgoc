package bai7_abstract_interface.baitap.resizable;

import bai6_kethua.thuchanh.Rectangle;

public class ResizableRectangle extends Rectangle implements Resize {
    public ResizableRectangle() {
    }

    public ResizableRectangle(double width, double length) {
        super(width, length);
    }

    public ResizableRectangle(double width, double length, String color, boolean filled) {
        super(width, length, color, filled);
    }

    @Override
    public void reSize(double percent) {
        this.setLength(super.getLength()+ super.getLength()*percent/100);
        this.setWidth(super.getWidth() + super.getWidth()*percent/100);
    }
}
