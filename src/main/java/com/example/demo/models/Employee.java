package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name="employee_id")
    private int employeeId;

    @Column(name="department")
    private String department;

    @NotEmpty(message = "You must supply an employee name")
    @Column(name="name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private EmployeeStatus status;

    public Employee() {
    }

    public Employee(int employeeId, String department, String name, EmployeeStatus status) {
        this.employeeId = employeeId;
        this.department = department;
        this.name = name;
        this.status = status;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
