package bai16_StringAndRegex.baitap.Class;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassExample {
    public static final String CLASS_REGEX = "[CAP]\\d{4}[GHIKLM]";
    public ClassExample() {

    }
    public static boolean validate(String string) {
        return Pattern.matches(CLASS_REGEX,string);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter class name test:");
        String stringInput = scanner.nextLine();
        System.out.println(validate(stringInput));
    }
}
