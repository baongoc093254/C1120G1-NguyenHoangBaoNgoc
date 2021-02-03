package CaseStudy.Controllers;

import CaseStudy.Commons.ReadAndWriteService_Customer.*;
import CaseStudy.Models.*;
import bai15_IO_BinaryFile_Serialization.baitap.ReadWriteProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerBooking {
    ManagerCustomer managerCustomer = new ManagerCustomer();
    ManagerServices managerServices = new ManagerServices();
    Booking booking = new Booking();
    static Scanner scanner = new Scanner(System.in);
    public  void addBooking() {
        List<Booking> bookingList = new ArrayList<>();
        List<Customer> customerList = FileUntils_Customer.readCustomer();
        managerCustomer.showCustomer();
        System.out.println("Enter customer !");
        int choiceCustomer = Integer.parseInt(scanner.nextLine());

        int idCustomer = customerList.get(choiceCustomer - 1).getIdCard();
        booking.setIdCustomer(idCustomer);
        System.out.println("----Enter services you want booking----");
        System.out.println("1. Booking Villa");
        System.out.println("2. Booking House");
        System.out.println("3. Booking Room");
        System.out.println("4. Back");
        int choiceBooking = Integer.parseInt(scanner.nextLine());
        switch (choiceBooking) {
            case 1:
                List<Villa> villaList = FileUntils_Villa.readVilla();
                managerServices.showVilla();
                System.out.println("Choose villa want book !");
                int choiceVilla = Integer.parseInt(scanner.nextLine());
                String idVillaBook = villaList.get(choiceVilla-1).getId();
                booking.setIdServices(idVillaBook);
                booking.setTypeRoom(villaList.get(choiceVilla -1).getTypeRoomvilla());
                break;
            case 2:
                List<House> houseList = FileUntil_House.readHouse();
                managerServices.showHouse();
                System.out.println("Choose House want book !");
                int choiceHouse = Integer.parseInt(scanner.nextLine());
                String idHouseBook = houseList.get(choiceHouse-1).getId();
                booking.setIdServices(idHouseBook);
                break;
            case 3:
                List<Room> roomList = FileUntil_Room.readRoom();
                managerServices.showRoom();
                System.out.println("Choose Room want book !");
                int choiceRoom = Integer.parseInt(scanner.nextLine());
                String idRoomBook = roomList.get(choiceRoom-1).getId();
                booking.setIdServices(idRoomBook);
                break;
            case 4:
                break;
            default:
                System.out.println("Failed");
                break;
        }
        bookingList.add(booking);
        FileUntils_Booking.writeBooking(bookingList,true);

    }
    public void showBooking() {
        List<Booking> listBooking = FileUntils_Booking.readBooking();
        int i = 1;
        for (Booking booking1: listBooking) {
            System.out.println(i + ". " + booking1.getIdCustomer() + booking1.getIdServices() + booking1.getTypeRoom());
            i++;
        }
    }
}
