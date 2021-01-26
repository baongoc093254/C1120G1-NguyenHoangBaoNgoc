package CaseStudy.Models;

public class Services {
    private String nameService;
    private double area;
    private double price;
    private int numberPeople;
    private String rentDay;

    public Services() {
    }

    public Services(String nameService, double area, double price, int numberPeople, String rentDay) {
        this.nameService = nameService;
        this.area = area;
        this.price = price;
        this.numberPeople = numberPeople;
        this.rentDay = rentDay;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    public void setNumberPeople(int numberPeople) {
        this.numberPeople = numberPeople;
    }

    public String getRentDay() {
        return rentDay;
    }

    public void setRentDay(String rentDay) {
        this.rentDay = rentDay;
    }

    @Override
    public String toString() {
        return "Services " +
                "nameService = '" + nameService + '\'' +
                ", area = " + area +
                ", price = " + price +
                ", numberPeople = " + numberPeople +
                ", rentDay = '" + rentDay + '\'';
    }
}
