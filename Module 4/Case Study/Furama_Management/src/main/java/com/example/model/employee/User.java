package com.example.model.employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user",
        uniqueConstraints = {
                @UniqueConstraint(name = "USER_UK", columnNames = "username")
        })
public class User {

    @Id
    @Column(name = "username")
    private String name;

    @Column(name = "password")
    private String password;
    @Column(name = "enabled", length = 1, columnDefinition = "BIT DEFAULT 1")
    private boolean enabled;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserRole> userRoles;

    public User() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
