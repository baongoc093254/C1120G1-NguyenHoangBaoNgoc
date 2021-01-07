package bai3_array_java.baitap;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhập vào số phần tử mảng 1. " );
            n = scanner.nextInt();
        }while (n <=0);
        int m;
        do {
            System.out.println("Nhập vào số phần tử mảng 2.");
            m = scanner.nextInt();
        }while (m <= 0);
        int[] arrayA = new int[n];
        for (int i = 0; i < arrayA.length ; i++) {
            System.out.println("Nhập phần tử thứ" + (i+1) + " : ");
            arrayA[i] = scanner.nextInt();

        }
        int[] arrayB = new int[m];
        for (int i = 0; i < arrayB.length ; i++) {
            System.out.println("Nhập phần tử thứ " + (i+1) +" : ");
            arrayB[i] = scanner.nextInt();

        }
        int[] arrayC = new int[n+m];
        for (int i = 0; i < arrayA.length ; i++) {
            arrayC[i] = arrayA[i];
        }
        for (int i = 0; i < arrayB.length ; i++) {
            arrayC[i+arrayB.length-1] = arrayB[i];
        }
        System.out.println("Mảng C sau khi gộp");
        for (int i = 0; i < arrayC.length ; i++) {
            System.out.println(arrayC[i]);
        }

    }
}
