package bai3_array_java.baitap;

import java.util.Arrays;

public class Max2Chieu {
    public static void main(String[] args) {
        int array [][] = new int [5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = i;
            }

        }
        for (int[] value : array){
            System.out.println(Arrays.toString(value) + "\t");
        }
     }
}
