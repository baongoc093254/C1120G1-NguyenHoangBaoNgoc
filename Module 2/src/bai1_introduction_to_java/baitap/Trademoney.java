package bai1_introduction_to_java.baitap;

import java.util.Scanner;

public class Trademoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền USD bạn muốn chuyển đổi sang VNĐ:");
        double money = scanner.nextDouble();
        double rate = money * 23000;
        System.out.println(money + " $ đổi được " + rate + " VNĐ");

    }
}
