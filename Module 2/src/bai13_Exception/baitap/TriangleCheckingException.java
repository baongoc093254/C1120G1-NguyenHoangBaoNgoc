package bai13_Exception.baitap;

public class TriangleCheckingException extends Exception  {
    public TriangleCheckingException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Error enter three side of triangle : " + super.getMessage();
    }
}
