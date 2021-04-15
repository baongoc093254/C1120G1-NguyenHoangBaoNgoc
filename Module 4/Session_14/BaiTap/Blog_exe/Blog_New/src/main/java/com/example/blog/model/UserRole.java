package com.example.blog.model;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name = "User_Role", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "USER_ROLE_UK", columnNames = { "User_Id", "Role_Id" }) })
public class UserRole {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private com.example.blog.model.AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "Role_Id", nullable = false)
    private com.example.blog.model.AppRole appRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public com.example.blog.model.AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(com.example.blog.model.AppUser appUser) {
        this.appUser = appUser;
    }

    public com.example.blog.model.AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(com.example.blog.model.AppRole appRole) {
        this.appRole = appRole;
    }

}
