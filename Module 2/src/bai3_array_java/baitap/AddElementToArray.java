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
        System.out.println("Nhập số x cần chèn");
        int x = scanner.nextInt();
        System.out.println("Nhập vị trí index muốn chèn x vào mảng");
        int index = scanner.nextInt();
        boolean check = true;
        if (index <= 1 && index >= array.length - 1) {
            System.out.println("Với vị trí" + index + " thì không chèn" + x + " vào mảng được");
        }
        for (int i = index; i < array.length - 1; i++) {
            array[i + 1] = array[i];
            check = false;
            break;
        }
        System.out.println("Mảng sau khi thêm phần tử " + x + " vào:");
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i] + " ");
        }
    }
}
