package CaseStudy.Models;

public class Employee {
    private String idEmployee;
    private String nameEmployee;
    private int age;
    private String address;

    public Employee() {
    }

    public Employee(String idEmployee, String nameEmployee, int age, String address) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.age = age;
        this.address = address;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", nameEmployee='" + nameEmployee + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public String showInfor() {
        return idEmployee + "," + nameEmployee + "," + age + "," + address;
    }
}
