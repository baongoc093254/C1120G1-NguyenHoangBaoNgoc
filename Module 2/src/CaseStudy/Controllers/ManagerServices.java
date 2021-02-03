package CaseStudy.Controllers;

import CaseStudy.Commons.ReadAndWriteService_Customer.FileUntil_House;
import CaseStudy.Commons.ReadAndWriteService_Customer.FileUntil_Room;
import CaseStudy.Commons.ReadAndWriteService_Customer.FileUntils_Villa;
import CaseStudy.Commons.Validation.ServicesValidator;
import CaseStudy.Models.House;
import CaseStudy.Models.Room;
import CaseStudy.Models.Villa;


import java.util.*;

public class ManagerServices {
    Scanner scanner = new Scanner(System.in);
    public void addNewVilla() {
         List<Villa> villaList = new ArrayList<>();
         String id;
         String nameServices;
         Float areaUsing;
         Double price;
         int numPeople;
         String rentDays;
         String typeRoom;
         Float areaPool;
         int numfloor;


        System.out.println("Enter information Villa:");
//        Enter id
        do {
            System.out.println("Enter id: (SVXX-YYYY) - YYYY - (0-9) - XX = (VL-villa/HO - house/RO - room)");
            id = scanner.nextLine();
            if(!ServicesValidator.validateIdVilla(id)) {
                System.out.println("Invalid ID service !");
            }
        }while (!ServicesValidator.validateIdVilla(id));

//        Enter name services
        do {
            System.out.println("Enter Name Services:");
            nameServices = scanner.nextLine();
            if (!ServicesValidator.validateNameService(nameServices)) {
                System.out.println("Invalid Name Services:");
            }

        }while (!ServicesValidator.validateNameService(nameServices));

        do {
            System.out.println("Enter area using:");
            areaUsing = Float.parseFloat(scanner.nextLine());
            if (!ServicesValidator.validateAreaUsing(areaUsing)) {
                System.out.println("Area using must greater than 30 !");
            }
        }while (!ServicesValidator.validateAreaUsing(areaUsing));

        do {
            System.out.println("Enter prices:");
            price = Double.parseDouble(scanner.nextLine());
            if (!ServicesValidator.validatePrice(price)) {
                System.out.println("Invalid price !");
            }
        }while (!ServicesValidator.validatePrice(price));

        do {
            System.out.println("Enter number people:");
            numPeople = Integer.parseInt(scanner.nextLine());
            if (!ServicesValidator.validateNumPeople(numPeople)) {
                System.out.println("Number people must greater than 0 and lower than 20 !");
            }
        }while (!ServicesValidator.validateNumPeople(numPeople));


            System.out.println("Enter rent days");
            rentDays = scanner.nextLine();


        do {
            System.out.println("Type room villa:");
            typeRoom = scanner.nextLine();
            if (!ServicesValidator.validateTypeRoom(typeRoom)) {
                System.out.println("First character must upper case !");
            }
        }while (!ServicesValidator.validateTypeRoom(typeRoom));

        do {
            System.out.println("Area Pool:");
            areaPool = Float.parseFloat(scanner.nextLine());
            if (!ServicesValidator.validateAreaPool(areaPool)) {
                System.out.println("Area pool must greater than 30 !");
            }
        }while (!ServicesValidator.validateAreaPool(areaPool));

        do {
            System.out.println("Enter number floor:");
            numfloor = Integer.parseInt(scanner.nextLine());
            if (!ServicesValidator.validateFloor(numfloor)) {
                System.out.println("Invalid");
            }
        }while (!ServicesValidator.validateFloor(numfloor));

            System.out.println("Enter other aminities");
            String otherAminities = scanner.nextLine();



        Villa villa = new Villa(id,nameServices,areaUsing,price,numPeople,rentDays,typeRoom,areaPool,numfloor,otherAminities);
        villaList.add(villa);
        FileUntils_Villa.writeVilla(villaList,true);
    }
    public void addNewHouse() {
        List<House> houseList = new ArrayList<>();
        System.out.println("Enter information House:");
        String id;
        String nameServices;
        Float areaUsing;
        Double price;
        int numPeople;
        String rentDays;
        String typeRoom;
        String otherAminities;
        int numfloor;
        do {
            System.out.println("Enter id:");
             id = scanner.nextLine();
            if (!ServicesValidator.validateIdHouse(id)) {
                System.out.println("Invalid ID !");
            }
        }while (!ServicesValidator.validateIdHouse(id));

        do {
            System.out.println("Enter Name Services:");
            nameServices = scanner.nextLine();
            if (!ServicesValidator.validateNameService(nameServices)) {
                System.out.println("Invalid name services !");
            }
        }while (!ServicesValidator.validateNameService(nameServices));

        do {
            System.out.println("Enter area using:");
            areaUsing = Float.parseFloat(scanner.nextLine());
            if (!ServicesValidator.validateAreaUsing(areaUsing)) {
                System.out.println("Area using must greater than 30 !");
            }
        }while (!ServicesValidator.validateAreaUsing(areaUsing));

        do {
            System.out.println("Enter prices:");
            price = Double.parseDouble(scanner.nextLine());
            if (!ServicesValidator.validatePrice(price)) {
                System.out.println("Price not lower than 0 !");
            }
        }while (!ServicesValidator.validatePrice(price));

        do {
            System.out.println("Enter number people:");
            numPeople = Integer.parseInt(scanner.nextLine());
            if (!ServicesValidator.validateNumPeople(numPeople)) {
                System.out.println("Number people must greater than 0 and lower than 20 !");
            }
        }while (!ServicesValidator.validateNumPeople(numPeople));

            System.out.println("Enter rent days");
            rentDays = scanner.nextLine();

        do {
            System.out.println("Type room house:");
            typeRoom = scanner.nextLine();
            if (!ServicesValidator.validateTypeRoom(typeRoom)) {
                System.out.println("Invalid type room");
            }
        }while (!ServicesValidator.validateTypeRoom(typeRoom));

            System.out.println("Enter other aminities");
            otherAminities = scanner.nextLine();
        do {
            System.out.println("Enter number floor:");
            numfloor = Integer.parseInt(scanner.nextLine());
            if (!ServicesValidator.validateFloor(numfloor)) {
                System.out.println("Invalid floor");
            }
        }while (!ServicesValidator.validateFloor(numfloor));

        House house = new House(id,nameServices,areaUsing,price,numPeople,rentDays,typeRoom,otherAminities,numfloor);
        houseList.add(house);
        FileUntil_House.writeHouse(houseList,true);

    }
    public void addNewRoom() {
        List<Room> roomsList = new ArrayList<>();
        String id;
        String nameServices;
        float areaUsing;
        double price;
        int numPeople;
        String rentDays;
        String freeServices;

        System.out.println("Enter information Room:");
        do {
            System.out.println("Enter id:");
            id = scanner.nextLine();
            if (!ServicesValidator.validateIdRoom(id)) {
                System.out.println("Invalid");
            }
        }while (!ServicesValidator.validateIdRoom(id));

        do {
            System.out.println("Enter Name Services:");
            nameServices = scanner.nextLine();
            if (!ServicesValidator.validateNameService(nameServices)) {
                System.out.println("Invalid");
            }
        }while (!ServicesValidator.validateNameService(nameServices));

        do {
            System.out.println("Enter area using:");
            areaUsing = Float.parseFloat(scanner.nextLine());
            if (!ServicesValidator.validateAreaUsing(areaUsing)) {
                System.out.println("Area using must greater than 30 !");
            }
        }while (!ServicesValidator.validateAreaUsing(areaUsing));

        do {
            System.out.println("Enter prices:");
            price = Double.parseDouble(scanner.nextLine());
            if (!ServicesValidator.validatePrice(price)) {
                System.out.println("Invalid");
            }
        }while (!ServicesValidator.validatePrice(price));

        do {
            System.out.println("Enter number people:");
            numPeople = Integer.parseInt(scanner.nextLine());
            if (!ServicesValidator.validateNumPeople(numPeople)) {
                System.out.println("Number people must greater than 0 and lower than 20 !");
            }
        }while (!ServicesValidator.validateNumPeople(numPeople));


        System.out.println("Enter rent days");
         rentDays = scanner.nextLine();

        System.out.println("Enter free services:");
         freeServices = scanner.nextLine();

        Room room = new Room(id,nameServices,areaUsing,price,numPeople,rentDays,freeServices);
        roomsList.add(room);
        FileUntil_Room.writeRoom(roomsList,true);
    }
    public void showVilla() {
        List<Villa> villaList = FileUntils_Villa.readVilla();
        int i = 1;
        for(Villa villa : villaList){
            System.out.println(i + ". " + villa.showInfor());
            i++;
        }
    }
    public void showHouse() {
        List<House> houseListList = FileUntil_House.readHouse();
        int i = 1;
        for (House house: houseListList) {
            System.out.println(i + ". " + house.showInfor());
            i++;
        }
    }
    public void showRoom() {
        List<Room> roomList = FileUntil_Room.readRoom();
        int i = 1;
        for (Room room: roomList) {
            System.out.println(i+ ". " + room.showInfor());
            i++;
        }
    }
    public void showNameVillaNotDuplicate() {
        List<Villa> villaList = FileUntils_Villa.readVilla();
        TreeSet<Villa> villaTreeSet = new TreeSet<>(villaList);
        int i =1;
        for (Villa villa: villaTreeSet) {
            System.out.println(i+ ". " + villa.showInfor());
            i++;
        }
    }
    public void showNameHouseNotDuplicate() {
        List<House> houseList = FileUntil_House.readHouse();
        TreeSet<House> houseTreeSet = new TreeSet<>(houseList);
        int i =1;
        for (House house: houseTreeSet) {
            System.out.println(i + ". " + house.showInfor());
            i++;
        }
    }
    public void showNameRoomNotDuplicate() {
        List<Room> roomList = FileUntil_Room.readRoom();
        TreeSet<Room> roomTreeSet = new TreeSet<>(roomList);
        int i =1;
        for (Room room: roomTreeSet) {
            System.out.println(i + ". " + room.showInfor());
            i++;
        }
    }


}
