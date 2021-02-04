package CaseStudy.Controllers;

import CaseStudy.Commons.ReadAndWriteService_Customer.FileUntils_Customer;
import CaseStudy.Models.Customer;
import CaseStudy.Models.Ticket;

import java.util.*;

public class ManagerTicket {
    static ManagerCustomer managerCustomer = new ManagerCustomer();
    static Scanner scanner = new Scanner(System.in);
    static Queue<Ticket> ticketList = new LinkedList<>();
    public void addNewTicket() {
        if (ticketList.size() == 5) {
            System.out.println("Sold out!");
        } else {
            List<Customer> customerList = FileUntils_Customer.readCustomer();
            Ticket ticket = new Ticket();

            managerCustomer.showCustomer();
            System.out.println("Choose customer !");
            int choiceCustomer = Integer.parseInt(scanner.nextLine());
            ticket.setIdTicket(Integer.toString(customerList.get(choiceCustomer-1).getIdCard()));
            ticket.setNamCustomer((customerList.get(choiceCustomer-1).getName()));
            ticketList.offer(ticket);
            System.out.println("OK");
        }
    }
    public void showTicket() {
        if (ticketList.size() == 5) {
            while (!ticketList.isEmpty()) {
                System.out.println(ticketList.poll().showInfo());
            }
        } else {
            System.out.println("NOT Sold out yet " + (5 - ticketList.size())+" tickets left");
        }
    }
}
