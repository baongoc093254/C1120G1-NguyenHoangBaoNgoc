package bai12_Searching_Algorithms.baitap;

import bai12_Searching_Algorithms.thuchanh.BinarySearch;

public class BinarySearchByDQ {
    public static int binarySearch(int[] array,int value, int low, int high) {
        low = 0;
        high = array.length - 1;
        int mid = (high + low) / 2;
        if (array[mid] == value ) {
            return mid;

//            Search the left half
        } else if (array[mid] > value) {
            return binarySearch(array,value,low,mid -1);
        } else if (array[mid] < value) {
            return binarySearch(array,value,mid +1, high);
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch obj = new BinarySearch();
        int[] number = {2,3,5,7,12,13,14,12,14,15,21,22};
        int n = number.length;
        int value = 13;
        int result = binarySearch(number,value,0,n-1);
        if (result == -1) {
            System.out.println("Not available");
        } else {
            System.out.println("Element found at index " + result);
        }

    }

}


