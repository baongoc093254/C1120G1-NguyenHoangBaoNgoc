package bai6_kethua.baitap;

public class Point3D extends Point2D {
    private float z;

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
        this(0.0f);
    }

    public float getZ() {
        return z;
    }


    //    class Display3D() {
    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        System.out.println(point3D);
    }
}