package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "patient")

public class Patient {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) //=AUTOINCREMENT
   @Column(name="patient_id")
   private int patientId;

    @NotEmpty(message = "You must supply a patient name")
   @Column(name="name")
    private String name;

   @Column(name="date_of_birth")
   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

   @ManyToOne //varios pacientes pueden ser admitidos por la misma persona
   @JoinColumn(name = "admitted_by", referencedColumnName = "employee_id")
       private Employee admittedBy;

    public Patient() {
    }

    public Patient(String name, LocalDate dateOfBirth, Employee admittedBy) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.admittedBy = admittedBy;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Employee getAddmitedBy() {
        return admittedBy;
    }

    public void setAddmitedBy(Employee admittedBy) {
        this.admittedBy = admittedBy;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", addmitedBy=" + admittedBy +
                '}';
    }
}
