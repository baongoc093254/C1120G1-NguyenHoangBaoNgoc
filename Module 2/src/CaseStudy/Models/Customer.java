package CaseStudy.Models;

public class Customer {
    private String name;
    private String dayOfBirth;
    private String gender;
    private int idCard;
    private int phone;
    private String email;
    private String rankCustomer;
    private String address;
    private Services useServices;

    public Customer() {
    }

    public Customer(String name, String dayOfBirth, String gender,
                    int idCard, int phone, String email,
                    String rankCustomer, String address) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.rankCustomer = rankCustomer;
        this.address = address;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRankCustomer() {
        return rankCustomer;
    }

    public void setRankCustomer(String rankCustomer) {
        this.rankCustomer = rankCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getUseServices() {
        return useServices;
    }

    public void setUseServices(Services useServices) {
        this.useServices = useServices;
    }

    public String showInforCustomer() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", idCard=" + idCard +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", rankCustomer='" + rankCustomer + '\'' +
                ", address=" + address + '}';
    }

    public String toString() {
        return name + "," + dayOfBirth + "," + gender
                + "," + idCard + "," +  phone + "," + email
                + "," + rankCustomer + "," + address;
    }

}
