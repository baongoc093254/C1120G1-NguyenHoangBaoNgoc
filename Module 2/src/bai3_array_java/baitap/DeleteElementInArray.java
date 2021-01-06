package bai3_array_java.baitap;

import java.util.Scanner;

public class DeleteElementInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println("Enter size :");
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
        System.out.println("Enter number you want deleted");
        int x = scanner.nextInt();
        int index_del=0;
        boolean check = true;
        for (int j = 0; j < array.length ; j++) {
            if (array[j] == x) {
                index_del = j;
                System.out.println("Find " + x + " in list at position " + index_del);
                check = false;
                break;
            }

        }  if (check){
            System.out.println("Not find " + x + " in list");

        }


        for (int j = index_del; j < array.length -1 ; j++) {
            array[j] = array[j+1];
        }
        array[array.length -1] = 0;
        System.out.println("Mảng còn lại sau khi xoá phần tử " + x);
        for (int j = 0; j < array.length ; j++) {
            System.out.println(array[j] + " ");
        }


    }
}
