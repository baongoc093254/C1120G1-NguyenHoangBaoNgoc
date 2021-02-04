package CaseStudy.Controllers;

import CaseStudy.Commons.ReadAndWriteService_Customer.FileUntilEmployee;
import CaseStudy.Models.Employee;

import java.util.*;

public class ManagerEmployee {

    public void showEmployee() {
        List<Employee> employeeList = FileUntilEmployee.readEmployee();
        Map<String, Employee> map = new HashMap<>();
        for (Employee employee: employeeList) {
            map.put(employee.getIdEmployee(),employee);
        }
        for (Map.Entry<String, Employee> entry : map.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue().showInfor());
        }


    }

}
