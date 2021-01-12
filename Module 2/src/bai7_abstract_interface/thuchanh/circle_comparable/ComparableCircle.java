package bai7_abstract_interface.thuchanh.circle_comparable;

import bai6_kethua.baitap.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean fille) {
        super(radius, color, fille);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius())
            return 1;
        else if (getRadius() < o.getRadius())
        return -1;
        else return  1;
    }
}
