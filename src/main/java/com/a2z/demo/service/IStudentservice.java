package com.a2z.demo.service;

import com.a2z.demo.model.Student;

import java.util.List;

public interface IStudentservice {
    Student getStudent(Integer rno);

    List<Student> getAllStudents();

    String createStudent(Student student);

    String updateStudent(Student student);

    String deleteStudent(Integer id);

}
