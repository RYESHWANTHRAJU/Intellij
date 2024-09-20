package com.a2z.demo.model;

public class Employee {
    // Attributes
    private int id;
    private String name;
    private String department;
    private double salary;
    private String email;

    // Default Constructor
    public Employee() {
    }

    // Parameterized Constructor
    public Employee(int id, String name, String department, double salary, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString method (optional, but useful)
    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", department=" + department
                + ", salary=" + salary + ", email=" + email + "]";
    }
}

