package CaseStudy.Models;

public class House extends Services {
    private String typeRoom;
    private String typeServices;
    private int floor;

    public House(String typeRoom, String typeServices, int floor) {
        this.typeRoom = typeRoom;
        this.typeServices = typeServices;
        this.floor = floor;
    }

    public House(String nameService, double area, double price, int numberPeople, String rentDay, String typeRoom, String typeServices, int floor) {
        super(nameService, area, price, numberPeople, rentDay);
        this.typeRoom = typeRoom;
        this.typeServices = typeServices;
        this.floor = floor;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public String getTypeServices() {
        return typeServices;
    }

    public void setTypeServices(String typeServices) {
        this.typeServices = typeServices;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House " +
                "typeRoom = '" + typeRoom + '\'' +
                ", typeServices = '" + typeServices + '\'' +
                ", floor = " + floor;
    }
}
