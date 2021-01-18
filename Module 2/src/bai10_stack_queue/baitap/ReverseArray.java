package bai10_stack_queue.baitap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class ReverseArray {
    public static void reverseArr (int[] array) {
        Stack<Integer> stackNum = new Stack<>();
        System.out.println("Pre-Reverse");
        for (int i : array) {
            stackNum.push(i);
        }
        System.out.println(stackNum);
        System.out.println("Reverse");
        for (int j = 0; j < array.length ; j++) {
            array[j] = stackNum.pop();
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] arrayList = {1,2,3,4,5};
        reverseArr(arrayList);
    }
}

