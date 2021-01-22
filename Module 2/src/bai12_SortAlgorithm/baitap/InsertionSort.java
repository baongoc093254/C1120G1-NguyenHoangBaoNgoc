package bai12_SortAlgorithm.baitap;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class InsertionSort {
    static int[] list = {3,5,7,1,4,8,9,10,11,13,15};
    public static void insertionSortt(int[] list) {
        for (int i = 0; i < list.length ; i++) {
//            insert list[i] into a sorted sublist list [0 ... i-1] so that list [0...i] sorted
            int currentElementt = list[i];
            int k;
            for (k = i-1; k >= 0 && list[k] > currentElementt ; k--) {
                list[k+1] = list[k];
            }
//            insert the current elemtn into list [k+1]
            list[k+1]  = currentElementt;
        }
    }

    public static void main(String[] args) {
        System.out.println("Before Sort !");
        for (int i = 0; i < list.length ; i++) {
            System.out.println(list[i]+ "\t");
        }
        System.out.println("Begin Sort !");
        insertionSortt(list);
        for (Integer listnumber: list) {
            System.out.print(listnumber);
        }
    }
}
