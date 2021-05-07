package Model;

public class Contract {
    private int idContract;
    private String contract_type_pay;
    private String dateOrder;
    private String dateSend;
    private String addressSend;
    protected Employee employee;
    protected Customer customer;

    public Contract(int idContract, String contract_type_pay, String dateOrder, String dateSend, String addressSend, Employee employee, Customer customer) {
        this.idContract = idContract;
        this.contract_type_pay = contract_type_pay;
        this.dateOrder = dateOrder;
        this.dateSend = dateSend;
        this.addressSend = addressSend;
        this.employee = employee;
        this.customer = customer;
    }

    public Contract() {
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public String getContract_type_pay() {
        return contract_type_pay;
    }

    public void setContract_type_pay(String contract_type_pay) {
        this.contract_type_pay = contract_type_pay;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getDateSend() {
        return dateSend;
    }

    public void setDateSend(String dateSend) {
        this.dateSend = dateSend;
    }

    public String getAddressSend() {
        return addressSend;
    }

    public void setAddressSend(String addressSend) {
        this.addressSend = addressSend;
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
}
