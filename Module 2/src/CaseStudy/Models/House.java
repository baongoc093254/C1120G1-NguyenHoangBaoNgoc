package CaseStudy.Models;

public class House extends Services implements Comparable<House>{
    private String typeRoomHouse;
    private String otherAmenities;
    private int floorNumber;

    public House(String typeRoomHouse, String otherAmenities, int floorNumber) {
        this.typeRoomHouse = typeRoomHouse;
        this.otherAmenities = otherAmenities;
        this.floorNumber = floorNumber;
    }

    public House(String id, String nameServices, float areaUsing, double prices,
                 int numberPeople, String rentDays, String typeRoomHouse,
                 String otherAmenities, int floorNumber) {
        super(id, nameServices, areaUsing, prices, numberPeople, rentDays);
        this.typeRoomHouse = typeRoomHouse;
        this.otherAmenities = otherAmenities;
        this.floorNumber = floorNumber;
    }

    public String getTypeRoomHouse() {
        return typeRoomHouse;
    }

    public void setTypeRoomHouse(String typeRoomHouse) {
        this.typeRoomHouse = typeRoomHouse;
    }

    public String getOtherAmenities() {
        return otherAmenities;
    }

    public void setOtherAmenities(String otherAmenities) {
        this.otherAmenities = otherAmenities;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String showInfor() {
        return "House \t" + super.showInfor() +
                " typeRoomHouse ='" + typeRoomHouse + '\'' +
                ", otherAmenities ='" + otherAmenities + '\'' +
                ", floorNumber =" + floorNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "," + typeRoomHouse + "," + otherAmenities + "," + floorNumber;
    }

    @Override
    public int compareTo(House o) {
        return this.getNameServices().compareTo(o.getNameServices());
    }
}
