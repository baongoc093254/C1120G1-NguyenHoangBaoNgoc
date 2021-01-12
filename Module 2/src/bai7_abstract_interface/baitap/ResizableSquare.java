package bai7_abstract_interface.baitap;

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
    public void Resize(double percent) {
        super.setSide(super.getSide() + getSide()*percent/100);
    }
}
