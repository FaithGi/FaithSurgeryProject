package com.FaithSurgery.controller;

import com.FaithSurgery.model.Patient;
import com.FaithSurgery.services.SurgeonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Doctors")
public class DoctorController
{

    @Autowired
    SurgeonServices service;

    @GetMapping("/View all patients for the day")
    public List<Patient> ViewAllPatients(){
        return service.findAll();
    }



}
