package bai15_IO_BinaryFile_Serialization.baitap;

import bai6_kethua.thuchanh.Rectangle;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);
    public void addNewProduct() {
        List<Product> list = new ArrayList<>();
        System.out.println("Add new product");
        System.out.println("Enter id :");
        String id = scanner.nextLine();
        System.out.println("Enter name product:");
        String name = scanner.nextLine();
        System.out.println("Enter Manufacter:");
        String manufacter = scanner.nextLine();
        System.out.println("Enter price :");
        float price = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter another infor :");
        String anotherinfor = scanner.nextLine();
        Product product = new Product(id,name,manufacter,price,anotherinfor);
        list.add(product);
        ReadWriteProduct.writeProduct(list,true);
    }
    public void showInforProduct() {
        List<Product> productList = ReadWriteProduct.readProduct();
        for (int i = 0; i < productList.size() ; i++) {
            System.out.println((i+1) + "." + productList.get(i));
        }
    }
    public void editInfor() {
        List<Product> list = ReadWriteProduct.readProduct();
        showInforProduct();
        boolean flag = true;
        System.out.println("Enter id product to edit");
        int choose = Integer.parseInt(scanner.nextLine());
        while (flag) {
            System.out.println("Choose value edit\n" +
                    "1. Name\n" +
                    "2. Price\n" +
                    "3. Manufactor\n" +
                    "4. Another infor\n" +
                    "5. Exit");
            int choose1 = Integer.parseInt(scanner.nextLine());
            switch (choose1) {
                case 1:
                    System.out.println("Enter new name");
                    String name = scanner.nextLine();
                    list.get(choose-1).setName(name);
                    break;
                case 2:
                    System.out.println("Enter new price");
                    float price = Float.parseFloat(scanner.nextLine());
                    list.get(choose-1).setPrice(price);
                    break;
                case 3:
                    System.out.println("Enter new Manufactor");
                    String manufactor = scanner.nextLine();
                    list.get(choose-1).setManufacter(manufactor);
                    break;
                case 4:
                    System.out.println("Enter new another");
                    String anotherInfor = scanner.nextLine();
                    list.get(choose-1).setAnotherInfor(anotherInfor);
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Error, please try again !");
                    break;
            }
        }
        ReadWriteProduct.writeProduct(list,false);
    }
    public void deleteProduct() {
        List<Product> list = ReadWriteProduct.readProduct();
        showInforProduct();
        System.out.println("Enter id product want delete");
        int choose = Integer.parseInt(scanner.nextLine());
        list.remove(choose-1);
        ReadWriteProduct.writeProduct(list,false);
    }
    public void searchByName() {
        List<Product> list = ReadWriteProduct.readProduct();
        showInforProduct();
        System.out.println("Enter name product you want search");
        String nameSearch = scanner.nextLine();
        for (Product product: list) {
            if (product.getName().contains(nameSearch)) {
                System.out.println(product);
            }
        }
    }
}
