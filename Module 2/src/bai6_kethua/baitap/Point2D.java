package bai6_kethua.baitap;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;

    }

    public float[] getXY() {
        float[] point2D = new float[2];
        point2D[0] = x;
        point2D[1] = y;
        return point2D;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x="  +getX() + "," +
                 "y=" + getY() +
                '}';
    }
}

    class Display2D{
    public static void main(String[]args){
        Point2D point2D = new Point2D(5.0f,7.5f);
        System.out.println(point2D);
        }
}

