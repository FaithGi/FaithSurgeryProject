package com.FaithSurgery.controller;


import com.FaithSurgery.configurartions.DatabaseConnection;
import com.FaithSurgery.model.Patient;
import com.FaithSurgery.services.PatientsServices;
import com.FaithSurgery.services.SurgeonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Patients")
public class PatientsCrontroller {

    @Autowired
    PatientsServices service;

    @PostMapping("/Book Appointment")
    public ResponseEntity<Patient> createBooking(@RequestBody Patient patient){
        try {

            DatabaseConnection databaseConnection = new DatabaseConnection();

            if(databaseConnection.countPatients() <= 5) {

                Patient patient1 = service.save(patient);
                return new ResponseEntity<>(patient, HttpStatus.CREATED);

           }else
            {
                return new ResponseEntity("booking for the day is full,try again tomorrow", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e){
            return new ResponseEntity(e.getLocalizedMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/Confirm List")
    public List<Patient> confirmBooking(){
        return service.findAll();
    }

    @DeleteMapping(value = "/reverse Appointment")
    public ResponseEntity<Patient> reverseBooking(@RequestParam("Id") int Id){
        this.service.deleteById(Id);
        return new ResponseEntity("User Deleted",HttpStatus.OK);
    }

    @PutMapping("/update appointment details")
    public ResponseEntity<Patient> updateBooking(@RequestBody Patient patient){

        if(!service.findById(patient.getId()).isPresent()){
            Patient patient1 = service.findById(patient.getId()).get();
            patient1.setFirstName(patient.getFirstName());
            patient1.setLastName(patient.getLastName());
            patient1.setBookingDate(patient.getBookingDate());
            patient1.setGender(patient.getGender());
            service.save(patient1);
            return new ResponseEntity("",HttpStatus.OK);
        }else{
            System.out.println("Patient Does'nt exist");
        }

        return new ResponseEntity(this.service.save(patient),HttpStatus.OK);
    }



}
