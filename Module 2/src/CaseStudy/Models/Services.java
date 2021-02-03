package CaseStudy.Models;

public class Services {
    private String id;
    private String nameServices;
    private float areaUsing;
    private double prices;
    private int numberPeople;
    private String rentDays;

    public Services() {
    }

    public Services(String id, String nameServices, float areaUsing,
                    double prices, int numberPeople, String rentDays) {
        this.id = id;
        this.nameServices = nameServices;
        this.areaUsing = areaUsing;
        this.prices = prices;
        this.numberPeople = numberPeople;
        this.rentDays = rentDays;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameServices() {
        return nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public float getAreaUsing() {
        return areaUsing;
    }

    public void setAreaUsing(float areaUsing) {
        this.areaUsing = areaUsing;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    public void setNumberPeople(int numberPeople) {
        this.numberPeople = numberPeople;
    }

    public String getRentDays() {
        return rentDays;
    }

    public void setRentDays(String rentDays) {
        this.rentDays = rentDays;
    }


    public String showInfor() {
        return "Services: " +
                "id ='" + id + '\'' +
                ", nameServices = '" + nameServices + '\'' +
                ", areaUsing = " + areaUsing +
                ", prices = " + prices +
                ", numberPeople = " + numberPeople +
                ", rentDays = '" + rentDays + '\'';
    }
    public String toString() {
        return  id + "," + nameServices + "," + areaUsing + "," + prices + "," +
                numberPeople + "," + rentDays ;
    }
}
