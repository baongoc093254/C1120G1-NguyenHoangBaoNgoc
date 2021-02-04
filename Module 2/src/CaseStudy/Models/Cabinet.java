package CaseStudy.Models;

import CaseStudy.Commons.ReadAndWriteService_Customer.FileUntilEmployee;
import CaseStudy.Controllers.ManagerEmployee;
import java.util.List;
import java.util.Stack;

public class Cabinet {
    static Stack<Employee> employeeStack = new Stack<>();
    public static void addCabinet() {
        List<Employee> employeeList = FileUntilEmployee.readEmployee();
        for (Employee employee: employeeList) {
            employeeStack.push(employee);
        }
    }
    public static void findEmployeeByName(String name) {
        if (employeeStack.isEmpty()) {
            System.out.println("Cabinet empty!");
        }else {
            while (!employeeStack.isEmpty()) {
                Employee employee = employeeStack.pop();
                if (employee.getNameEmployee().equals(name)) {
                    System.out.println(employee);
                    return;
                }
            }
            System.out.println("Not found Name Employee " + name);
        }

    }
    public static void findEmployeeById(String idEmployee) {
        if (employeeStack.isEmpty()) {
            System.out.println("Cabinet empty !");
        }else {
            while (!employeeStack.isEmpty()) {
                Employee employees = employeeStack.pop();
                if (employees.getIdEmployee().equals(idEmployee)) {
                    System.out.println(employees);
                    return;
                }
            }
            System.out.println("Not find Id Employee " +idEmployee);
        }
    }




}
