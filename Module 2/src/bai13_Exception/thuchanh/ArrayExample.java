package bai13_Exception.thuchanh;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("List element !");
        for (int i = 0; i < 100 ; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i] + "\t");
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer[] arr = arrayExample.createRandom();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter random index you want find !");
        int x = scanner.nextInt();
        try {
            System.out.println("Value of element has index " + x + " is " + arr[x] );
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Element out of range of array !");
        }
    }
}
