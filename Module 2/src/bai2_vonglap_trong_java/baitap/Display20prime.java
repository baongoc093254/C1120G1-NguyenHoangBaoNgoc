package bai2_vonglap_trong_java.baitap;

import java.util.Scanner;

public class Display20prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Nhập số nguyên tố bạn muốn in ra:");
        number = scanner.nextInt();
        int count = 0;
        int countflag = 0;
        int prime = 2;
        while (count < number) {
            countflag = 0;
            for (int i = 1; i <= Math.sqrt(prime); i++) {
                if (prime % i == 0) {
                    countflag++;
                }
            }
            if (countflag == 1) {
                System.out.println(prime + " ");
                count++;
            }
            prime++;
        }
    }
}
