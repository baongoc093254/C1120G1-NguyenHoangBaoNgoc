package bai15_IO_BinaryFile_Serialization.baitap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        int choice;
        boolean flagMenu = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("MENU");
            System.out.println("1. Add new product ");
            System.out.println("2. Show all product ");
            System.out.println("3. Edit infor product ");
            System.out.println("4. Delete product ");
            System.out.println("5. Search product by name ");
            System.out.println("6. Exit ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManager.addNewProduct();
                    break;
                case 2:
                    productManager.showInforProduct();
                    break;
                case 3:
                    productManager.editInfor();
                    break;
                case 4:
                    productManager.deleteProduct();
                    break;
                case 5:
                    productManager.searchByName();
                    break;
                case 6:
                    flagMenu = false;
                    break;

            }
        } while (flagMenu);
    }
}
