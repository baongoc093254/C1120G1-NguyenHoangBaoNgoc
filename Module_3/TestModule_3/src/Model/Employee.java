package Model;

public class Employee {
    private int idEmployee;
    private String nameEmployee;
    private String dobEmployee;
    private int phoneEmployee;
    private String addressEmployee;
    private String email;

    public Employee() {
    }

    public Employee(int idEmployee, String nameEmployee, String dobEmployee, int phoneEmployee, String addressEmployee, String email) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.dobEmployee = dobEmployee;
        this.phoneEmployee = phoneEmployee;
        this.addressEmployee = addressEmployee;
        this.email = email;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getDobEmployee() {
        return dobEmployee;
    }

    public void setDobEmployee(String dobEmployee) {
        this.dobEmployee = dobEmployee;
    }

    public int getPhoneEmployee() {
        return phoneEmployee;
    }

    public void setPhoneEmployee(int phoneEmployee) {
        this.phoneEmployee = phoneEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
