package com.example.model.contract;


import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "attach_service")
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attach_service_id")
    private Integer id;

    @Column(name = "attach_service_name")
    private String name;

    @Pattern(regexp = "^[0-9]*[1-9][0-9]*(\\.[0-9]+)?$", message = "Cost invalid !")
    @Column(name = "attach_service_cost")
    private String cost;

    @Pattern(regexp = "^[0-9]*[1-9][0-9]*(\\.[0-9]+)?$", message = "Unit invalid, unit must be > 0 !")
    @Column(name = "attach_service_unit")
    private String unit;

    @Column(name = "attach_service_status")
    private String status;

    public AttachService() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
