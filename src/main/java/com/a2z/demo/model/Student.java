package com.a2z.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "demo_students")
public class Student
{
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rno;
    private String name;
    private String branch;
    private String gender;
    private double cgpa;

    public Student(){}

    public Student(Integer rno, String name, String branch, String gender, double cgpa) {
        this.rno = rno;
        this.name = name;
        this.branch = branch;
        this.gender = gender;
        this.cgpa = cgpa;
    }

    public Integer getRno() {
        return rno;
    }

    public void setRno(Integer rno) {
        this.rno = rno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rno=" + rno +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", gender='" + gender + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}
