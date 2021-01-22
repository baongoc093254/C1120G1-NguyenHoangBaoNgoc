package bai12_SortAlgorithm.baitap;

import java.util.Scanner;

public class InsertionSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter list size");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " value");
        for (int i = 0; i < list.length ; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.println("Input your list !");
        for (int i = 0; i < list.length ; i++) {
            System.out.println(list[i] + "\t");
        }
        System.out.println("Begin sort ...");
        insertionSort(list);
    }
    public static void insertionSort(int[] list) {
        for (int i = 0; i < list.length ; i++) {
            int currentElement = list[i];
            int j;
            for (j = i - 1; j >= 0 && list[j] > currentElement;j--) {
             list[j + 1] = list[j];
            }
            list[j+1] = currentElement;
            System.out.println("List after " + i + " sort !" );
            for (int k = 0; k < list.length ; k++) {
                System.out.print(list[k] + "\t");
            }
        }
        
    }
}
