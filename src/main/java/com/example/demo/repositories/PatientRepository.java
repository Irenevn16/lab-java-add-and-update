package com.example.demo.repositories;

import com.example.demo.models.EmployeeStatus;
import com.example.demo.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    public Patient addPatient();
    public Patient updatePatientInfo();

}