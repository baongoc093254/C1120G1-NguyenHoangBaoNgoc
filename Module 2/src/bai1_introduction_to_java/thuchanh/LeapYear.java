package bai1_introduction_to_java.thuchanh;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bạn muốn kiểm tra năm nào ? : ");
        int year = scanner.nextInt();
        if (year % 4 == 0 && year % 100 != 0) {
            System.out.print("Năm " + year + " là năm nhuận.");
        } else if (year % 100 == 0 && year % 400 != 0) {
            System.out.print("Năm " + year + " không phải là năm nhuận.");
        } else if (year % 100 == 0 && year % 400 == 0) {
            System.out.print("Năm " + year + " là năm nhuận.");
        }

    }
}
