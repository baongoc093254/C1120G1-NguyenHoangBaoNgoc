package bai3_array_java.thuchanh;

import java.util.Scanner;

public class FindIndexarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter studen name :");
        String name = scanner.nextLine();
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        boolean flag = true;
        for (int i = 0; i < students.length ; i++) {
            if (students[i].equals(name)) {
                System.out.println("Position of the student in the list " + name + " is " + (i+1));
                flag = false;
                break;
            }

        }
        if (flag) {
            System.out.println("Not found " + name + "in the list.");
        }


    }
}
