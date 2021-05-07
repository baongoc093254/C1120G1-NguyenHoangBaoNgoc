package com.example.model.contract;

import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.service.Service;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "contract")
public class Contract implements Validator {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer id;

    @Pattern(regexp = "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])",message = " Right format YYYY-MM-DD")
    @Column(name = "contract_start_date", columnDefinition = "date")
    private String startDate;

    @Pattern(regexp = "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])",message = "Right format YYYY-MM-DD")
    @Column(name = "contract_end_date", columnDefinition = "date")
    private String endDate;

    @NotBlank(message = "Deposit not empty")
    @Pattern(regexp = "^[0-9]*[1-9][0-9]*(\\.[0-9]+)?$", message = "Deposit invalid")
    @Column(name = "contract_deposit")
    private String deposit;


    @Column(name = "contract_total_money")
    private String total;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    private Service service;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contract")
    private Set<ContractDetail> contractDetails;

    public Contract() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
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

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
