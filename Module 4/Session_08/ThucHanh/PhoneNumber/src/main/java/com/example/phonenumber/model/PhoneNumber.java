package com.example.phonenumber.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class PhoneNumber implements Validator {
    @NotEmpty(message = "Phone number not empty !")
    @Size(min = 10,max = 11, message = "Phone number must 10 to 11 element !")
    private String number;

    public PhoneNumber() {
    }

    public String  getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PhoneNumber.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        PhoneNumber phoneNumber = (PhoneNumber) object ;
        String number = phoneNumber.getNumber();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"number", "number.empty");
        if (number.length() < 10 || number.length() > 11){
            errors.rejectValue("number", "phoneNumber.number.min.max");
        }
        if (!number.startsWith("0")) {
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("number", "number.matches");
        }
    }
}
