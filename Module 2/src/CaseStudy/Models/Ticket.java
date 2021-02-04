package CaseStudy.Models;

public class Ticket {
    private String idTicket;
    private double price = 45.0d;
    private String namCustomer;

    public Ticket() {
    }

    public Ticket(String idTicket, double price, String nameCustomer) {
        this.idTicket = idTicket;
        this.price = price;
        this.namCustomer = nameCustomer;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNamCustomer() {
        return namCustomer;
    }

    public void setNamCustomer(String namCustomer) {
        this.namCustomer = namCustomer;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "idTicket='" + idTicket + '\'' +
                ", price=" + price +
                ", namCustomer='" + namCustomer + '\'' +
                '}';
    }
    public String showInfo() {
        return idTicket + "," + price + "," + namCustomer;
    }

}
