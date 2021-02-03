package CaseStudy.Models;

public class Villa extends Services implements Comparable<Villa> {
    private String typeRoomvilla;
    private float poolArea;
    private int floorNumber;
    private String otherAmenities;

    public Villa(String typeRoomvilla, float poolArea, int floorNumber, String otherAmenities) {
        this.typeRoomvilla = typeRoomvilla;
        this.poolArea = poolArea;
        this.floorNumber = floorNumber;
        this.otherAmenities = otherAmenities;
    }

    public Villa(String id, String nameServices, float areaUsing,
                 double prices, int numberPeople, String rentDays,
                 String typeRoomvilla, float poolArea, int floorNumber, String otherAmenities) {
        super(id, nameServices, areaUsing, prices, numberPeople, rentDays);
        this.typeRoomvilla = typeRoomvilla;
        this.poolArea = poolArea;
        this.floorNumber = floorNumber;
        this.otherAmenities = otherAmenities;
    }

    public String getTypeRoomvilla() {
        return typeRoomvilla;
    }

    public void setTypeRoomvilla(String typeRoomvilla) {
        this.typeRoomvilla = typeRoomvilla;
    }

    public float getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(float poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getOtherAmenities() {
        return otherAmenities;
    }

    public void setOtherAmenities(String otherAmenities) {
        this.otherAmenities = otherAmenities;
    }

    @Override
    public String showInfor() {
        return "Villa \t" + super.showInfor() +
            " typeRoomvilla = '" + typeRoomvilla + '\'' +
                    ", poolArea = " + poolArea +
                    ", floorNumber = " + floorNumber +
                    ", otherAmenities = '" + otherAmenities + '\'';
    }

    @Override
    public String toString() {
        return super.toString() + "," + typeRoomvilla + "," + poolArea + ","
                + floorNumber + "," + otherAmenities;
    }

    @Override
    public int compareTo(Villa o) {
        return this.getNameServices().compareTo(o.getNameServices());
    }
}
