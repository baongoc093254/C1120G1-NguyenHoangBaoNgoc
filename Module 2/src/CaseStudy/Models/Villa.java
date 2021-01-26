package CaseStudy.Models;

public class Villa extends Services {
    private String typeRoom;
    private String typeService;
    private double poolArea;
    private int floor;

    public Villa(String typeRoom, String typeService, double poolArea, int floor) {
        this.typeRoom = typeRoom;
        this.typeService = typeService;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public Villa(String nameService, double area, double price, int numberPeople, String rentDay, String typeRoom, String typeService, double poolArea, int floor) {
        super(nameService, area, price, numberPeople, rentDay);
        this.typeRoom = typeRoom;
        this.typeService = typeService;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Villa " +
                "typeRoom = '" + typeRoom + '\'' +
                ", typeService = '" + typeService + '\'' +
                ", poolArea = " + poolArea +
                ", floor = " + floor;
    }
}
