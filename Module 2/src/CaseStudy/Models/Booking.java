package CaseStudy.Models;

public class Booking {
    private int idCustomer;
    private String idServices;
    private String typeRoom;

    public Booking(int idCustomer, String idServices, String typeRoom) {
        this.idCustomer = idCustomer;
        this.idServices = idServices;
        this.typeRoom = typeRoom;
    }

    public Booking() {
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdServices() {
        return idServices;
    }

    public void setIdServices(String idServices) {
        this.idServices = idServices;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idCustomer=" + idCustomer +
                ", idServices='" + idServices + '\'' +
                ", typeRoom='" + typeRoom + '\'' +
                '}';
    }
    public String showInfor() {
        return idCustomer + "," + idServices + "," + typeRoom;
    }
}
