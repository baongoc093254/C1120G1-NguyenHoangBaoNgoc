package bai15_IO_BinaryFile_Serialization.baitap;

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
            System.out.println((i+1) + ". " + productList.get(i));
        }
    }
}
