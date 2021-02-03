package CaseStudy.Commons.ReadAndWriteService_Customer;

import CaseStudy.Models.Customer;
import CaseStudy.Models.Services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUntils_Customer {
    static final String PATH_CUSTOMER = "Module 2/src/CaseStudy/Data/Customer.csv";
    static File file = new File(PATH_CUSTOMER);
    public static void writeCustomer(List<Customer> customerList,boolean selection) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer: customerList) {
                bufferedWriter.write(customer.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error input file !");
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<Customer> readCustomer() {
        List<Customer> customerList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arrCustomer = null;
            while ((line = bufferedReader.readLine()) != null) {
                arrCustomer = line.split(",");
                Customer customer = new Customer(arrCustomer[0],arrCustomer[1],arrCustomer[2],
                        Integer.parseInt(arrCustomer[3]),Integer.parseInt(arrCustomer[4]),arrCustomer[5],
                        arrCustomer[6], arrCustomer[7]);
                customerList.add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
