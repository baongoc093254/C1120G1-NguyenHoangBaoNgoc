package bai11_HashMap_LinkedHashMap_TreeMap.baitap.LuyenTap_ArrayList_LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
        ArrayList<Product> productArrayList = new ArrayList<Product>();
        Scanner scanner = new Scanner(System.in);
        public void add() {
            System.out.print("Enter ID:");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter name product:" );
            String nameProduct = scanner.nextLine();
            System.out.print("Enter price: ");
            float price = Float.parseFloat(scanner.nextLine());
            Product product = new Product(id,nameProduct,price);
            productArrayList.add(product);
            System.out.println("Done !");
            }
            public void show() {
                for (Product information: productArrayList) {
                    System.out.println(information);
                }
            }
            public void edit() {
                System.out.println("Enter ID");
                int id = Integer.parseInt(scanner.nextLine());
                for (Product value : productArrayList) {
                    if (value.getId() == id) {
                        System.out.println("Edit information product:");
                        System.out.println("Enter new name: ");
                        String nameNew = scanner.nextLine();
                        System.out.println("Enter new price: ");
                        float priceNew = Float.parseFloat(scanner.nextLine());
                        value.setName(nameNew);
                        value.setCost(priceNew);
                        break;
                    }
//                    else {
//                        System.out.println("Not available");
//                    }
                }
            }
            public void delete() {
                System.out.println("Enter ID you want delete:");
                int id = scanner.nextInt();
                for (int index = 0; index < productArrayList.size() ; index++) {
                    if (productArrayList.get(index).getId() == id) {
                        productArrayList.remove(index);
                        break;
                    }
                }
                System.out.println("Done !");
            }
            public void search() {
                System.out.println("Enter name product :");
                String nameSearch = scanner.nextLine();
                for (int index = 0; index < productArrayList.size() ; index++) {
                    if (productArrayList.get(index).getName().equals(nameSearch)) {
                        System.out.println(productArrayList.get(index));
                    }

                }
            }
            public void sort() {
            ComparatorByPrice comparatorByPrice = new ComparatorByPrice();
                Collections.sort(productArrayList,comparatorByPrice);
                for (Product sort : productArrayList) {
                    System.out.println(sort);
                }
            }

        }




