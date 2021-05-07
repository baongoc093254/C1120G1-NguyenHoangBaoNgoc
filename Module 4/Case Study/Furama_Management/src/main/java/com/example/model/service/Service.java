package com.example.model.service;

import com.example.model.contract.Contract;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @Pattern(regexp = "^(DV-)\\d{4}$", message = "Code must be DV-XXXX")
    @Column(name = "service_id")
    private String id;

    @Column(name = "service_name", length = 45, nullable = false)
    private String name;

    @NotBlank(message = "Area not empty")
    @Pattern(regexp = "^[0-9]*[1-9][0-9]*(\\.[0-9]+)?$", message = "Area must be XXXX")
    @Column(name = "service_area")
    private String area;

    @NotBlank(message = "Cost service not empty")
    @Pattern(regexp = "^[0-9]*[1-9][0-9]*(\\.[0-9]+)?$", message = "Cost invalid")
    @Column(name = "service_cost")
    private String cost;

    @NotBlank(message = "Number people not empty")
    @Pattern(regexp = "^[0-9]*[1-9][0-9]*(\\.[0-9]+)?$", message = "Max people must be < 100")
    @Column(name = "service_max_people")
    private String maxPeople;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rent_type_id", nullable = false)
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "service_type_id", nullable = false)
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<Contract> contractSet;

    @Column(name = "standard_room", length = 45)
    private String standardRoom;

    @Column(name = "description_other_convenience", length = 45)
    private String description;


    @Pattern(regexp = "^[0-9]*[1-9][0-9]*(\\.[0-9]+)?$", message = "Pool area must be < 1000")
    @Column(name = "pool_area")
    private String poolArea;

    @NotBlank(message = "Number floor not empty")
    @Pattern(regexp = "^[0-9]*[1-9][0-9]*(\\.[0-9]+)?$", message = "Number floor invalid")
    @Column(name = "number_floors")
    private String numberFloor;

    public Service() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(String numberFloor) {
        this.numberFloor = numberFloor;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
