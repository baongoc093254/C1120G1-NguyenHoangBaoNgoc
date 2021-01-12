package bai7_abstract_interface.baitap.resizable;

import bai6_kethua.thuchanh.Square;

public class ResizableSquare extends Square implements Resize {
    public ResizableSquare() {
    }

    public ResizableSquare(double side) {
        super(side);
    }

    public ResizableSquare(double side, String color, boolean filled) {
        super(side, color, filled);
    }


    @Override
    public void reSize(double percent) {
        this.setLength(super.getLength()+ super.getLength()*percent/100);
        this.setWidth(super.getWidth() + super.getWidth()*percent/100);
    }
}
