package com.example.formregister.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;

import javax.jws.soap.SOAPBinding;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "First name not empty")
    @Size(min = 5, max = 45, message = "First name must be 5 to 45 characters !")
    private String firstName;

    @NotBlank(message = "Last name not empty")
    @Size(min = 5,max = 45, message = "Last name must be 5 to 45 characters !")
    private String lastName;

    private String phoneNumber;

    @Email(message = "Email should be valid")
    @NotBlank
    private String email;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        if (user.phoneNumber.length() < 10 || user.phoneNumber.length() > 11) {
            errors.rejectValue("phoneNumber", "user.min.max.phoneNumber");
        }
        if (user.phoneNumber.startsWith("0")) {
            errors.rejectValue("phoneNumber", "user.phoneNumber.startWith");
        }
        if (user.phoneNumber.isEmpty()) {
            errors.rejectValue("phoneNumber", "user.phoneNumber.empty");
        }
        if (user.phoneNumber.matches("^$|[0-9]*$")) {
            errors.rejectValue("phoneNumber", "user.phoneNumber.matches");
        }
    }
}
