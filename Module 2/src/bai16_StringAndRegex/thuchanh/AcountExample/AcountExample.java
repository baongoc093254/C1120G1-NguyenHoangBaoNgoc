package bai16_StringAndRegex.thuchanh.AcountExample;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AcountExample {
    /*Không chứa các ký tự đặc biệt
	  Phải dài hơn 6 ký tự
	  Không chứa các ký tự viết hoa
	  Cho phép dấu gạch dưới (_)
	*/
    private static final String ACOUNT_REGEX = "^[_a-z0-9]{6,}$";
    public AcountExample() {

    }
    public static boolean validate(String regex) {
        Pattern pattern = Pattern.compile(ACOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("Enter account name:");
        Scanner scanner = new Scanner(System.in);
        String acoountName = scanner.nextLine();
        System.out.println(validate(acoountName));
    }
}
