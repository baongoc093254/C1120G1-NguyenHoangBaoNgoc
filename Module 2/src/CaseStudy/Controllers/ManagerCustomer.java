package CaseStudy.Controllers;

import CaseStudy.Commons.ReadAndWriteService_Customer.SortCustomer.SortByNameAndBirthDay;
import CaseStudy.Commons.Validation.CustomerValidation;
import CaseStudy.Commons.ReadAndWriteService_Customer.FileUntils_Customer;
import CaseStudy.Commons.Validation.UserException.EmailException;
import CaseStudy.Commons.Validation.UserException.IdcardException;
import CaseStudy.Commons.Validation.UserException.NameException;
import CaseStudy.Models.Customer;
import CaseStudy.Models.Ticket;

import java.util.*;

public class ManagerCustomer {
    Scanner scanner = new Scanner(System.in);
    public void addNewCustomer() {
        String name;
        int idcard;
        String dayOfBirth;
        String gender;
        int phoneNumber;
        String email;
        String rankCustomer;
        String address;


        List<Customer> customerList = new ArrayList<>();
        System.out.println("Add Information Customer");
        do {
            System.out.print("Add name customer : ");
            name = scanner.nextLine();
            try {
                if (!CustomerValidation.validateName(name)) {
                    throw new NameException("First character in name must upper case !");
                }
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        }while (!CustomerValidation.validateName(name));


            System.out.println("Enter Day Of Birth:");
            dayOfBirth = scanner.nextLine();


        System.out.println("Enter Gender:");
        gender = scanner.nextLine();
        do {
            System.out.println("Enter id card:");
            idcard = Integer.parseInt(scanner.nextLine());
            try {
                if (!CustomerValidation.validateIdCard(idcard)) {
                    throw new IdcardException("Id format XXX XXX XXX !");
                }
            } catch (IdcardException e) {
                System.out.println(e.getMessage());
            }
        }while (!CustomerValidation.validateIdCard(idcard));

        System.out.println("Enter Phone Number:");
        phoneNumber = Integer.parseInt(scanner.nextLine());
        do {
            System.out.println("Enter email:");
            email = scanner.nextLine();
            try {
                if (!CustomerValidation.validateEmail(email)) {
                    throw new EmailException("Email format abc@abc.abc !");
                }
            } catch (EmailException e) {
                System.out.println(e.getMessage());
            }
        }while (!CustomerValidation.validateEmail(email));

        System.out.println("Enter your rank customer:");
        rankCustomer = scanner.nextLine();
        System.out.println("Enter your address:");
        address = scanner.nextLine();
        Customer customer = new Customer(name,dayOfBirth,gender,idcard,
                phoneNumber,email,rankCustomer,address);
        customerList.add(customer);
        FileUntils_Customer.writeCustomer(customerList,true);

    }
    public void showCustomer() {
        List<Customer> customerList = FileUntils_Customer.readCustomer();
        Collections.sort(customerList,new SortByNameAndBirthDay());
        int i = 1;
        for (Customer customer: customerList) {
            System.out.println(i+". "+customer.showInforCustomer());
            i++;
        }

    }


}
