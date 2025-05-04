package com.example.demo.controllers;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.PatientDTO;
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
    public Patient addPatient(@RequestBody @Valid PatientDTO dto) {
        return hospitalService.addPatient(dto);
    }

    @PostMapping("/doctor")
    @ResponseStatus(HttpStatus.OK)
    public Employee addDoctor(@RequestBody @Valid EmployeeDTO dto) {
        return hospitalService.addDoctor(dto);
    }

    @PatchMapping("/doctor/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Employee updateEmployeeStatus(@PathVariable("id") int id, @RequestBody EmployeeDTO dto) {
        return hospitalService.updateEmployeeStatus(id, dto.toString());

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