package bai11_HashMap_LinkedHashMap_TreeMap.baitap.LuyenTap_ArrayList_LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice  = -1;
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager1 = new ProductManager();

        while (choice !=0) {
            System.out.println("MENU:");
            System.out.println("1. Add information product: ");
            System.out.println("2. Show information product: ");
            System.out.println("3. Edit information product: ");
            System.out.println("4. Delete product:");
            System.out.println("5. Search product:");
            System.out.println("6. Sort product:");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1. Add product :");
                    productManager1.add();
                    break;
                case 2:
                    System.out.println("2. Show information product");
                    productManager1.show();
                    break;
                case  3:
                    System.out.println("3. Edit information product");
                    productManager1.edit();
                    break;
                case 4:
                    System.out.println("4. Find information product");
                    productManager1.delete();
                    break;
                case 5 :
                    System.out.println("5. Search product:");
                    productManager1.search();
                    break;
                case 6:
                    System.out.println("Sort product by Price");
                    productManager1.sort();
                    break;
                default:
                    break;
            }
        }
    }
}
