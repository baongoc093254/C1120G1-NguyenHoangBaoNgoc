package bai16_StringAndRegex.thuchanh.AcountExample;

import java.util.Scanner;

public class AcountExampleTest {
    private static AcountExample acountExample;
    public static final String[] validAcount = new String[] {"123abc_", "_abc123", "______", "123456","abcdefgh"};
    public static final String[] invalidAcount = new String[] {".@", "12345", "1234_", "abcde"};

    public static void main(String[] args) {
        acountExample = new AcountExample();
        for (String acount: validAcount) {
            boolean isvalid = acountExample.validate(acount);
            System.out.println("Acount is " + acount + " is valid: " + isvalid);
        }
        for (String acount: invalidAcount) {
            boolean isvalid = acountExample.validate(acount);
            System.out.println("Acount is " + acount + " is valid: " + isvalid);
        }
    }
}
