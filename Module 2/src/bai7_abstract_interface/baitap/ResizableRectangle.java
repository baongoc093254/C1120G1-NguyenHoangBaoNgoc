package bai7_abstract_interface.baitap;

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
    public void resize(double percent) {
        this.setLength(getLength()+ getLength()*percent/100);
        this.setWidth(getWidth()+getWidth()*percent/100);
    }

}
