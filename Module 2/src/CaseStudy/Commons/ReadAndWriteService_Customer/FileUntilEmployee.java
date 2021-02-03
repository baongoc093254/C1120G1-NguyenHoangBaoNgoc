package CaseStudy.Commons.ReadAndWriteService_Customer;

import CaseStudy.Models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUntilEmployee {
    public static final String PATH_EMPLOYEE = "Module 2/src/CaseStudy/Data/Employee.csv";
    static File file = new File(PATH_EMPLOYEE);
    public static void writeEmploy(List<Employee> employeeList,boolean selection) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,selection);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee: employeeList) {
                bufferedWriter.write(employee.showInfor());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<Employee> readEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] arrEmployee;
            while ((line = bufferedReader.readLine()) != null) {
                arrEmployee = line.split(",");
                Employee employee = new Employee(arrEmployee[0],arrEmployee[1],Integer.parseInt(arrEmployee[2]),arrEmployee[3]);
                employeeList.add(employee);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;

    }


}
