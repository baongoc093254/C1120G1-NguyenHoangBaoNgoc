package bai2_vonglap_trong_java.baitap;

import java.util.Scanner;

public class Display_prime_100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count  = 0;
        int countflag = 0;
        int prime = 2;
        while (prime < 100) {
            countflag = 0;
            for (int i = 1; i <= Math.sqrt(prime) ; i++) {
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



