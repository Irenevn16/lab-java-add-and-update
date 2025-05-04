package com.example.demo.dto;

import com.example.demo.models.Employee;

import java.time.LocalDate;

public class PatientDTO {
    public int patientId;
    public String name;
    public LocalDate dateOfBirth;
    public Employee admittedBy;
}
