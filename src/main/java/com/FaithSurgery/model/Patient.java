package com.FaithSurgery.model;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Patient{

    public Patient(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @NonNull
    private String firstName;
    private String lastName;
    private String Gender;
    private Date bookingDate;

}
