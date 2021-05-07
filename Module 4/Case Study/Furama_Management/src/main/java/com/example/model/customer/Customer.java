package com.example.model.customer;

import com.example.model.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Pattern(regexp = "^(KH-)\\d{4}$", message = "Code must be KH-XXXX")
    @Column(name = "customer_id", length = 45)
    private String id;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customer_type_id")
    private CustomerType customerType;

    @NotBlank(message = "Name is not empty")
    @Size(min = 5, max = 45, message =  "Name must be 5 to 45 characters")
    @Column(name = "customer_name", nullable = false)
    private String name;

    @Pattern(regexp = "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])",message = " Right format YYYY-MM-DD")
    @Column(name = "customer_birthday", nullable = false, columnDefinition = "DATE")
    private String birthday;

    @Column(name = "customer_gender")
    private String gender;

    @Pattern(regexp = "(^\\d{9}$)|(^\\d{12}$)", message = "ID Card is not valid")
    @Column(name = "customer_id_card", nullable = false)
    private String idCard;


    @Pattern(regexp = "(^(090)\\d{7}$)|(^(091)\\d{7}$)|(^(\\+\\(84\\) 90)\\d{7}$)|(^(\\+\\(84\\) 91)\\d{7}$)", message = "Phone number is not valid")
    @Column(name = "customer_phone", nullable = false)
    private String phoneNumber;

    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message = "Email is not valid")
    @Column(name = "customer_email")
    private String email;

    @Column(name = "customer_address", length = 45)
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Contract> contracts;

    public Customer() {
    }

    public Customer(CustomerType customerType, String name, String birthday, String gender, String idCard, String phoneNumber, String email, String address) {
        this.customerType = customerType;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }


}
