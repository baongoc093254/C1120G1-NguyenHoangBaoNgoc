package bai1_introduction_to_java.baitap;

import java.util.Scanner;

public class DisplayTheGreeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hiển thị lời chào.");
        System.out.print("Nhập tên :");
        String name = scanner.nextLine();
        System.out.println("Hello: " + name);
    }
}
