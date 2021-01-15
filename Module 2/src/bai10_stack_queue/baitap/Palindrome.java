package bai10_stack_queue.baitap;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static boolean checkPalindrome (String str) {
        Stack<Character> stackStr = new Stack<>();
        Queue<Character> queueStr = new ArrayDeque<>();
        for (int i = 0; i < str.length() ; i++) {
            stackStr.push(str.charAt(i));
            queueStr.offer(str.charAt(i));

        }

        for (int i = 0; i < stackStr.size() ; i++) {
            if (stackStr.pop() == queueStr.poll() ) {
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("TEST");
        String str = "abcfba";
        if (checkPalindrome(str)) {
            System.out.println(str +" is Palindrome");
        } else {
            System.out.println(str + " not Palindrome");
        }

    }

}
