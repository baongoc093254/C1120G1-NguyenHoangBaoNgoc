package bai10_stack_queue.baitap;

import java.util.Scanner;
import java.util.Stack;

import static java.lang.Math.pow;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner decimal = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println("Enter binary number: ");
        int binaryNumber = decimal.nextInt();
        int decimalNumber = 0;
        int i =0;
        while (binaryNumber != 0) {
            decimalNumber += ((binaryNumber%10)*Math.pow(2,i));
            binaryNumber = binaryNumber/10;
            i++;

        }
        stack.push(decimalNumber);
        System.out.println("Decimal : ");
        while (!(stack.isEmpty())) {
            System.out.print(stack.pop());
        }
        }

    }

