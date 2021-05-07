package Model;

public class Customer {
    private int idCustomer;
    private String nameCustomer;
    private String dobCustomer;
    private int phoneCustomer;
    private String addressCustomer;
    private String emailCustomer;

    public Customer() {
    }

    public Customer(int idCustomer, String nameCustomer, String dobCustomer, int phoneCustomer, String addressCustomer, String emailCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.dobCustomer = dobCustomer;
        this.phoneCustomer = phoneCustomer;
        this.addressCustomer = addressCustomer;
        this.emailCustomer = emailCustomer;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDobCustomer() {
        return dobCustomer;
    }

    public void setDobCustomer(String dobCustomer) {
        this.dobCustomer = dobCustomer;
    }

    public int getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(int phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }
}
