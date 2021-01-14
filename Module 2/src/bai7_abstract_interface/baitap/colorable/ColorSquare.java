package bai7_abstract_interface.baitap.colorable;

import bai6_kethua.thuchanh.Square;

public class ColorSquare extends Square implements Colorable {
    public ColorSquare() {
    }

    public ColorSquare(double side) {
        super(side);
    }

    public ColorSquare(double side, String color, boolean filled) {
        super(side, color, filled);
    }

    @Override
    public void howtoColor() {
        System.out.println("Color all four side");
    }
}
