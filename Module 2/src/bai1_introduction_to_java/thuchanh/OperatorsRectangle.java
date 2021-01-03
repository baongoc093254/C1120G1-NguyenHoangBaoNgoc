package bai1_introduction_to_java.thuchanh;

import java.util.Scanner;

public class OperatorsRectangle {
    public static void main(String[] args) {
        int height;
        int width;
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập chiều dài: ");
        height = scan.nextInt();
        System.out.print("Nhập chiều rộng: ");
        width = scan.nextInt();
        int area = height * width;
        System.out.print("Diện tích hình chữ nhật: " + area);
    }
}
