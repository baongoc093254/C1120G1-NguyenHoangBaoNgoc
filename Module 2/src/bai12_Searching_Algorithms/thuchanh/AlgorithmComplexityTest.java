package bai12_Searching_Algorithms.thuchanh;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string");
        String inputString = scanner.nextLine();
        int[] frequentChar = new int[255];
        for (int i = 0; i < inputString.length() ; i++) {
//            Find index at ASCII
            int ascii =  inputString.charAt(i);
//       Tang gia tri tan suat
            frequentChar[ascii] += 1;
//            find char apear
            int max = 0;
            char character = (char) 255;
            for (int j = 0; j < 255 ; j++) {
                if (frequentChar[j] > max) {
                    max = frequentChar[j];
                    character = (char) j;
                }
            }
            System.out.println("The most appearing letter is " + character + " with a frequency of " + max + " time");
        }
    }
}
