package bai3_array_java.baitap;

import java.util.Scanner;

public class AddElementToArray {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Nhập vào số phần tử của mảng");
            n = scanner.nextInt();
        } while (n <= 0);
        int[] array = new int[n];
        System.out.println("Nhập phần tử cho mảng :");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập phần tử thứ " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
        }
        int[] arrayNew = new int[n+1];
        System.out.println("Nhập số x cần chèn");
        int x = scanner.nextInt();
        int index;      // vị trí
        do {
            System.out.println("Nhập vị trí index muốn chèn x vào mảng");
             index = scanner.nextInt();
        }while (index > array.length);

        for (int i = 0; i < index ; i++) {
            arrayNew[i] = array[i];
            for (int j = index; j < array.length ; j++) {
                arrayNew[index] = x;
               arrayNew[j+1] = array[j];
            }
        }
        System.out.println("Mảng sau khi thêm phần tử " + x + " vào:");
        for (int i = 0; i < arrayNew.length ; i++) {
            System.out.println(arrayNew[i] + " ");
        }
    }
}
