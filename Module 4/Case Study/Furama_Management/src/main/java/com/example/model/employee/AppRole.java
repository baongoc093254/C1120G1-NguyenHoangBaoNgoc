package com.example.model.employee;

import javax.persistence.*;

@Entity
@Table(name = "role", uniqueConstraints = {
        @UniqueConstraint(name = "ROLE_UK", columnNames = "role_name")
})
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @Column(name = "role_name", columnDefinition = "VARCHAR(45)" , nullable = false)
    private String name;

    public AppRole() {
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
}
