package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.models.EmployeeStatus;
import com.example.demo.models.Patient;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.PatientRepository;
import com.example.demo.services.HospitalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital")

public class HospitalController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/patient")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient addPatient(@RequestBody @Valid Patient patient) {
        return hospitalService.addPatient(patient);
    }

    @PostMapping("/doctor")
    @ResponseStatus(HttpStatus.OK)
    public Employee addDoctor(@RequestBody @Valid Employee employee) {
        return hospitalService.addDoctor(employee);
    }

    @PatchMapping("/doctor/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Employee updateEmployeeStatus(@PathVariable("id") int id, @RequestBody Employee employee) {
        return hospitalService.updateEmployeeStatus(id, employee);

    }

    @PatchMapping("/doctor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateDoctorDepartment(@PathVariable int id, @RequestBody Employee employee) {
        return hospitalService.updateEmployeeDepartment(id, employee);
    }

    @PutMapping("/products/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updatePatient(@PathVariable int id, @RequestBody Patient patient) {
        hospitalService.updatePatient(id, patient);
    }
}