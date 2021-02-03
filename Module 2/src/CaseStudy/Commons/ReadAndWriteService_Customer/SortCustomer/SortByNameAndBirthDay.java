package CaseStudy.Commons.ReadAndWriteService_Customer.SortCustomer;

import CaseStudy.Models.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class SortByNameAndBirthDay extends Customer implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        if (o1.getName().compareTo(o2.getName()) > 0) {
            return 1;
        } else if (o1.getName().compareTo(o2.getName()) < 0) {
            return -1;
        } else {
            Date customer1Birthday = null;
            Date customer2Birthday = null;
            try {
                customer1Birthday = new SimpleDateFormat("dd/MM/yyyy").parse(o1.getDayOfBirth());
                customer2Birthday = new SimpleDateFormat("dd/MM/yyyy").parse(o2.getDayOfBirth());

            } catch (ParseException e) {
                e.printStackTrace();
            }
            return customer1Birthday.compareTo(customer2Birthday);
        }
    }
}
