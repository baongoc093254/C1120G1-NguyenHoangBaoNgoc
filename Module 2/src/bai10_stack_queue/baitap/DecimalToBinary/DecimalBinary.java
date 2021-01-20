package bai10_stack_queue.baitap.DecimalToBinary;

import java.util.Scanner;
import java.util.Stack;

public class DecimalBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println("Nhập vào số thập phân: ");
        int decimal = scanner.nextInt();
        while (decimal != 0) {
            int d = decimal % 2;
            stack.push(d);
            decimal /= 2;
        }
        System.out.print("\nGiá trị nhị phân là: ");
        while (!(stack.isEmpty())) {
            System.out.print(stack.pop());
        }
    }
}
