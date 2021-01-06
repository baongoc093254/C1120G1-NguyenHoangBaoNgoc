package bai3_array_java.thuchanh;

import java.util.Scanner;

public class FindMaxinArray {
    public static void main(String[] args) {
        int size;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter a size:");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.println("Size should not exceed 20");
            }
        }while (size > 20);
        int[] array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println("Enter element " + (i+1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.println("Property list: ");
        for (int j = 0; j < array.length ; j++) {
            System.out.println(array[j] + "\t");
        }
        int max = array[0];
        int index = 1;
        for (int j = 0; j < array.length ; j++) {
            if (array[j] > max) {
                max = array[j];
                index = j + 1;
            }

        }
        System.out.println("The largest propety value in the list is " + max + " position " + index);
    }

}
