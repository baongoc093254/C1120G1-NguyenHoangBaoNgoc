package Model;

public class Contract {
    private int contract_id;
    private String contract_start_date;
    private String contract_end_date;
    private double contract_deposit;
    private double contract_total_money;
    protected Employee employee;
    protected Customer customer;
    protected Service service;

    public Contract() {
    }

    public Contract(int contract_id, String contract_start_date, String contract_end_date, double contract_deposit, double contract_total_money, Employee employee, Customer customer, Service service) {
        this.contract_id = contract_id;
        this.contract_start_date = contract_start_date;
        this.contract_end_date = contract_end_date;
        this.contract_deposit = contract_deposit;
        this.contract_total_money = contract_total_money;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public String getContract_start_date() {
        return contract_start_date;
    }

    public void setContract_start_date(String contract_start_date) {
        this.contract_start_date = contract_start_date;
    }

    public String getContract_end_date() {
        return contract_end_date;
    }

    public void setContract_end_date(String contract_end_date) {
        this.contract_end_date = contract_end_date;
    }

    public double getContract_deposit() {
        return contract_deposit;
    }

    public void setContract_deposit(double contract_deposit) {
        this.contract_deposit = contract_deposit;
    }

    public double getContract_total_money() {
        return contract_total_money;
    }

    public void setContract_total_money(double contract_total_money) {
        this.contract_total_money = contract_total_money;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
