package bai3_array_java.thuchanh;


import java.util.Scanner;

public class FindMin {
    public static void main(String[] args) {
        int size;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter size");
            size = scanner.nextInt();
            if (size > 30) {
                System.out.println("Size should not exceed 30");
            }
        } while (size > 30);
        int[] array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println("Enter element " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        int index = minValue(array);
        System.out.println("The smallest element in the array is: " + minValue(array) + " position " + index);
    }
        public static int minValue(int[] array) {
            int min = array[0];
            for (int j = 0;j < array.length ; j++) {
                if (array[j] < min) {
                    min = array[j];
                }
            }
            return min;
        }
    }


