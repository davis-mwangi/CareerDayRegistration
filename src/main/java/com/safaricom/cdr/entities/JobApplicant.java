/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safaricom.cdr.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import static jdk.nashorn.internal.runtime.Debug.id;
import org.hibernate.annotations.GenericGenerator;
import static org.hibernate.criterion.Projections.id;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 *
 * @author david
 */
@Entity
@Table(name= "job_applicants")
public class JobApplicant {
    
     @Id
     @GeneratedValue(strategy=  GenerationType.AUTO)
     @Column(name= "id")
     private Long id;
    
    
    @Column(name = "first_name")
    private String first_name;
    
    @Column(name = "last_name")
    private String last_name;
    
    @Email
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "education_level")
    private String education_level;
    
    @Column(name = "years_of_experience")
    private int years_of_experience;

    @Column(name="created_at")
    private ZonedDateTime created_at;
    
    
    public JobApplicant() {
    }

    public JobApplicant(Long id, String first_name, String last_name, String email, String phone, String education_level, int years_of_experience, ZonedDateTime created_at) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.education_level = education_level;
        this.years_of_experience = years_of_experience;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEducation_level() {
        return education_level;
    }

    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }

    public int getYears_of_experience() {
        return years_of_experience;
    }

    public void setYears_of_experience(int years_of_experience) {
        this.years_of_experience = years_of_experience;
    }

    public ZonedDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(ZonedDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "JobApplicant{" + "id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email + ", phone=" + phone + ", education_level=" + education_level + ", years_of_experience=" + years_of_experience + ", created_at=" + created_at + '}';
    }

    
}
