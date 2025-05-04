package com.example.demo.services;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.PatientDTO;
import com.example.demo.models.Employee;
import com.example.demo.models.EmployeeStatus;
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

    public Patient addPatient(PatientDTO dto) {
        Patient p = new Patient();
        p.setPatientId(dto.patientId);
        p.setName(dto.name);
        p.setDateOfBirth(dto.dateOfBirth);
        p.setAddmitedBy(employeeRepository.findById(dto.admittedBy.getEmployeeId()).orElseThrow());

        return patientRepository.save(p);
    }
    public Employee addDoctor(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setEmployeeId(dto.employeeId);
        employee.setDepartment(dto.department);
        employee.setName(dto.name);
        employee.setStatus(EmployeeStatus.valueOf(String.valueOf(dto.status)));
        return employeeRepository.save(employee);
    }
    public Employee updateEmployeeStatus(int id, String newStatus) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow();
        existingEmployee.setStatus(EmployeeStatus.valueOf(newStatus));
        return employeeRepository.save(existingEmployee);
    }

    public Employee updateEmployeeDepartment(int id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow();
        existingEmployee.setDepartment(employee.getDepartment());
        return employeeRepository.save(existingEmployee);
    }
    public void updatePatient(int id, Patient patient) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        patient.setPatientId(patientOptional.get().getPatientId());
        patientRepository.save(patient);
    }
}
