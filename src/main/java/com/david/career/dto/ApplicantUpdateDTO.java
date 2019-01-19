/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.career.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *Object to interact using rest api.
 * @author david
 */
public class ApplicantUpdateDTO {
    
    @NotEmpty(message = "first_name can not be empty")
    @JsonProperty("first_name")
    private String firstName;
    
    @NotEmpty(message = "last_name cannot be empty")
    @JsonProperty("last_name")
    private String lastName;
    
    @Email
    @JsonProperty("email")
    private String email;
    
    @JsonProperty("phone_number")
    private String phoneNumber;
    
    @JsonProperty("education_level")
    private String educationLevel;
    
    @JsonProperty("years_of_experience")
    private int yearsOfExperience;
    
    @NotEmpty(message = "password can not be empty")
    @Size(min = 6, message = "password mut be at least 6 characters")
    @JsonProperty("password")
    private String password;
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
