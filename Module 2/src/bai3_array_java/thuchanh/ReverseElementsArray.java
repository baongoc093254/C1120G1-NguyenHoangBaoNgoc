package bai3_array_java.thuchanh;

import java.util.Scanner;

public class ReverseElementsArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
       int[] number;
       do {
           System.out.println("Enter size array");
           size = scanner.nextInt();
           if (size > 20) {
               System.out.println("Size does not exceep 20");
           }

       } while(size > 20);
       number = new int[size];
       int i = 0;
       while (i < number.length) {
           System.out.println("Enter element " + (i+1) + ": ");
           number[i] = scanner.nextInt();
           i++;
       }
        System.out.printf("%-20s%s","Elements in array: ", "");
        for (int j = 0; j < number.length ; j++) {
            System.out.println(number[j] + "\t");
        }
        for (int j = 0; j < number.length / 2 ; j++) {
            int temp = number[j];
            number[j] = number[size- 1 - j];
            number[size - 1 -j] = temp;
        }
        System.out.printf("%-20s%s","Elements in array: ", "");
        for (int j = 0; j < number.length ; j++) {
            System.out.println(number[j] + "\t");
        }

    }

}
