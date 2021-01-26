package CaseStudy.Models;

public class Room extends Services{
    private String freeServices;

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }

    public Room(String nameService, double area, double price, int numberPeople, String rentDay, String freeServices) {
        super(nameService, area, price, numberPeople, rentDay);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String toString() {
        return "Room " +
                "freeServices = '" + freeServices + '\'';
    }
}
