package bai6_kethua.thuchanh;

public class Square extends Rectangle {

        public Square() {
        }

        public Square(double side) {
            super(side, side);
        }

        public Square(double side, java.lang.String color, boolean filled) {
            super(side, side, color, filled);
        }

        public double getSide() {
            return getWidth();
        }

        public void setSide(double side) {
            setWidth(side);
            setLength(side);
        }

        @Override
        public void setWidth(double width) {
            setSide(width);
        }

        @Override
        public void setLength(double length) {
            setSide(length);
        }

        @Override
        public String toString() {
            return "A Square with side="
                    + getSide()
                    + ", which is a subclass of "
                    + super.toString();
        }
    }
    class SquareTest {
        public static void main(String[] args) {
            bai6_kethua.thuchanh.Square square = new bai6_kethua.thuchanh.Square();
            System.out.println(square);

            square = new bai6_kethua.thuchanh.Square(2.3);
            System.out.println(square);

            square = new bai6_kethua.thuchanh.Square(5.8, "yellow", true);
            System.out.println(square);
        }
    }

