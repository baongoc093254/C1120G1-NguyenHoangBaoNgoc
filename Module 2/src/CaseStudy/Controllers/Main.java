package CaseStudy.Controllers;

import CaseStudy.Models.Cabinet;
import CaseStudy.Models.Ticket;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ManagerServices managerServices = new ManagerServices();
    static ManagerCustomer managerCustomer = new ManagerCustomer();
    static ManagerBooking managerBooking = new ManagerBooking();
    static ManagerEmployee managerEmployee = new ManagerEmployee();
    static ManagerTicket managerTicket = new ManagerTicket();
    static Queue<Ticket> queue = new LinkedList<>();
    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean falgMenu = true;
        do {
            System.out.println("---MENU FURAMA RESORT---");
            System.out.println("1. Add New Services");
            System.out.println("2. Show Services");
            System.out.println("3. Add New Customer");
            System.out.println("4. Show Information of Customer");
            System.out.println("5. Add New Booking");
            System.out.println("6. Show Information of Employee");
            System.out.println("7. Services Cinema4D");
            System.out.println("8. Cabinet Employee");
            System.out.println("9. Exit");
            System.out.println("Enter your choice !");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
//                    Add new services
                    addNewServices();
                    break;
                case 2:
//                    show services
                    showServices();
                    break;
                case 3:
//                    add new customer
                    managerCustomer.addNewCustomer();
                    break;
                case 4:
//                    show information customer
                    managerCustomer.showCustomer();
                    break;
                case 5:
//                    add new booking
                    addNewBook();
                    break;
                case 6:
//                    add information of employee
                    managerEmployee.showEmployee();
                    break;
                case 7:
                    cinema4D();
                    break;
                case 8:
                    cabinetEmployee();
                    break;
                case 9:
                    System.exit(choice);
                    break;
                default:
                    System.out.println("Please try again !");
            }
        } while (falgMenu);
    }

    public static void addNewServices() {
        int choice1;
        Scanner scanner = new Scanner(System.in);
        boolean flagAddServices = true;
        do {
            System.out.println("Choose option you want add :");
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to menu");
            System.out.println("5. Exit");
            System.out.println("Enter your choice ");
            choice1 = Integer.parseInt(scanner.nextLine());
            switch (choice1) {
                case 1:
//                    add new villa
                    managerServices.addNewVilla();
                    break;
                case 2:
//                    add new house
                    managerServices.addNewHouse();
                    break;
                case 3:
//                    add new room
                    managerServices.addNewRoom();
                    break;
                case 4:
//                    back to menu
                    displayMainMenu();
                    break;
                case 5:
                    System.exit(choice1);
                    break;
                default:
                    System.out.println("Please choose again !");
                    break;
            }
        } while (flagAddServices);
    }

    public static void showServices() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        boolean checkShowServices = true;
        do {
            System.out.println("Show services:");
            System.out.println("1. Show all Villa");
            System.out.println("2. Show all House");
            System.out.println("3. Show all Room");
            System.out.println("4. Show all Villa not Duplicate");
            System.out.println("5. Show all House not Duplicate ");
            System.out.println("6. Show all Room not Duplicate");
            System.out.println("7. Back to menu");
            System.out.println("8. Exit");
            System.out.println("Enter your choice !");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
//                    show all villa
                    managerServices.showVilla();
                    break;
                case 2:
//                    show all house
                    managerServices.showHouse();
                    break;
                case 3:
//                    show all room
                    managerServices.showRoom();
                    break;
                case 4:
//                    show all name villa not duplicate
                    managerServices.showNameVillaNotDuplicate();
                    break;
                case 5:
//                    show all name house not duplicate
                    managerServices.showNameHouseNotDuplicate();
                    break;
                case 6:
//                    show all name room not diplicate
                    managerServices.showNameRoomNotDuplicate();
                    break;
                case 7:
//                    back to menu
                    checkShowServices = false;
                    break;
                case 8:
//                    exit
                    System.exit(choice);
                    break;
                default:
                    System.out.println("Please try again");
                    break;
            }
        } while (checkShowServices);
    }

    public static void addNewBook() {
        managerBooking.addBooking();
        managerBooking.showBooking();

    }
    public static void cinema4D() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        boolean checkCinema4D = true;

        do {
            System.out.println("---Cinema4D---");
            System.out.println("1. Book ticket");
            System.out.println("2. Show ticket");
            System.out.println("3. Back to menu");
            System.out.println("4. Exit");
            System.out.println("Enter your choice");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
//                    Add new ticket
                    managerTicket.addNewTicket();
                    break;
                case 2:
//                    Show all ticket
                    managerTicket.showTicket();
                    break;
                case 3:
                    checkCinema4D = false;
                    break;
                case 4:
                    System.exit(choice);
                    break;
                default:
                    System.out.println("Please try again !");

            }
        }while (checkCinema4D);
    }
    public static void cabinetEmployee() {
        int choice;
        boolean checkCabinet = true;
        Scanner scanner = new Scanner(System.in);
        do {
            Cabinet.addCabinet();
            System.out.println("---Cabinet Employee---");
            System.out.println("1. Find Employee by Name");
            System.out.println("2. Find Employee by Id Employee");
            System.out.println("3. Back to menu");
            System.out.println("4. Exit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
//                    Find employee by name
                    System.out.println("Enter name employee you want find :");
                    String nameFind = scanner.nextLine();
                    Cabinet.findEmployeeByName(nameFind);
                    break;
                case 2:
                    System.out.println("Enter id Employee you want find :");
                    String idEmployee = scanner.nextLine();
                    Cabinet.findEmployeeById(idEmployee);
                    break;
                case 3:
                    checkCabinet = false;
                    break;
                case 4:
                    System.exit(choice);
                    break;
                default:
                    System.out.println("Please try again !");
                    break;
            }
        }while (checkCabinet);

    }

}
