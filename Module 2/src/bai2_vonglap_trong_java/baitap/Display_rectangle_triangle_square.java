package bai2_vonglap_trong_java.baitap;

import java.util.Scanner;

public class Display_rectangle_triangle_square {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choose;
        System.out.println("Menu");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");     // tam giác vuông
        System.out.println("3. Print isosceles triangle");      // tam giác cân
        System.out.println("4. Exit");
        System.out.println("Enter your choice:");
        choose = scanner.nextInt();
        switch (choose) {
            case 1:
                System.out.println("Print the rectangle:");
                int height, width;
                System.out.println("Nhập chiều dài:");
                height = scanner.nextInt();
                System.out.println("Nhập chiều rộng");
                width = scanner.nextInt();
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        System.out.print(" * ");
                    }
                    System.out.println(); // in xuống dòng
                }
                break;
            case 2:
                System.out.println("Print the square triangle - bottom left");
                int a;
                System.out.println("Nhập chiều dài tam giác bạn muốn vẽ");
                a = scanner.nextInt();
                for (int i = 0; i <= a; i++) {
                    for (int j = 0; j < i; j++) {
                        System.out.print(" * ");
                    }
                    System.out.println();
                }
                System.out.println("Print square triangle - top left");
                int b;
                System.out.println("Nhập chiều dài của cạnh tam giác cân bạn muốn vẽ");
                b = scanner.nextInt();
                for (int i = b; i >= 1; i--) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print(" * ");
                    }
                    System.out.println();

                }

                break;
            case 3:
                System.out.println("Print isosceles triangle");
                System.out.println("Nhập chiều cao tam giác cân bạn muốn vẽ");
                int c = scanner.nextInt();

                break;

            case 4:
                System.exit(0);
            default:
                System.out.println("Failed - Try again.");
        }
    }
}