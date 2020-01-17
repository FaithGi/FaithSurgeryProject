package com.FaithSurgery.services;

import com.FaithSurgery.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeonServices extends JpaRepository<Patient, Long>{
}
