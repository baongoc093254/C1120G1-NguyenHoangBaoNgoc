package CaseStudy.Models;

public class Room extends Services implements Comparable<Room> {
    private String freeServices;


    public Room(String freeServices) {
        this.freeServices = freeServices;
    }

    public Room(String id, String nameServices, float areaUsing, double prices, int numberPeople, String rentDays, String freeServices) {
        super(id, nameServices, areaUsing, prices, numberPeople, rentDays);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String showInfor() {
        return "House \t" + super.showInfor() +
                " freeServices = '" + freeServices ;
    }

    @Override
    public String toString() {
        return super.toString() + "," + freeServices;
    }

    @Override
    public int compareTo(Room o) {
        return this.getNameServices().compareTo(o.getNameServices());
    }
}
