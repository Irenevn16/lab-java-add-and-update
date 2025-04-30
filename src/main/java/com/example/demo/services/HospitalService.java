package com.example.demo.services;

import com.example.demo.models.Employee;
import com.example.demo.models.Patient;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class HospitalService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PatientRepository patientRepository;

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    public Employee addDoctor(Employee employee) {
        return employeeRepository.save(employee);
    }
    public Employee updateEmployeeStatus(int id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        existingEmployee.setStatus(employee.getStatus());
        return employeeRepository.save(existingEmployee);
    }

    public Employee updateEmployeeDepartment(int id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow() new ResponseStatusException(HttpStatus.NOT_FOUND));
        existingEmployee.setDepartment(employee.getDepartment());
        return employeeRepository.save(existingEmployee);
    }
    public void updatePatient(int id, Patient patient) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        patient.setPatientId(patientOptional.get().getPatientId());
        patientRepository.save(patient);
    }
}
