package bai2_vonglap_trong_java.thuchanh;

import java.util.Scanner;

public class Bankinterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số tiền muốn gửi:");
        double money = scanner.nextDouble();
        System.out.println("Số tháng muốn gửi:");
        int month = scanner.nextInt();
        System.out.println("Tỉ lệ lãi suất theo tháng :");
        double interestrate = scanner.nextDouble();
        double total_moneyrate = 0;
        for (int i = 1; i < month; i++) {
            total_moneyrate += money * (interestrate/100)/12 * month;
            System.out.println("Total interest : " + total_moneyrate);
        }


    }
}
