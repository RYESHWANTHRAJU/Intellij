package com.a2z.demo.service;

import com.a2z.demo.controller.Employee;
import com.a2z.demo.model.Student;
import com.a2z.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IStudentServiceImpl implements IStudentservice
{
    private final StudentRepository studentRepository;
    List<Student> studentList=new ArrayList<>();
    public IStudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudent(Integer rno) {
        Optional<Student> optionalStudent=studentRepository.findById(rno);
        if(optionalStudent.isPresent()){
            return optionalStudent.get();
        }else{
            throw new RuntimeException("Employee not found with given id: "+rno);
        }
    }

    //List<Student> studentList=new ArrayList<>();

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public String createStudent(Student student) {
        Student student1=new Student(student.getRno(),student.getName(),student.getBranch(),student.getGender(),student.getCgpa());
        studentRepository.save(student1);
        //employeeList.add(employee);
        return "Student created successfully";
    }

    @Override
    public String updateStudent(Student student) {
        Optional<Student> optionalStudent=studentRepository.findById(student.getRno());
        if(optionalStudent.isPresent()){
            Student dbStudent=optionalStudent.get();
            dbStudent.setRno(student.getRno());
            dbStudent.setName(student.getName());
            dbStudent.setBranch(student.getBranch());
            dbStudent.setCgpa(student.getCgpa());
            studentRepository.save(dbStudent);
            return "Employee updated successfully";
        }else{
            throw new RuntimeException("Employee not found with given id: "+student.getRno());
        }
    }

    @Override
    public String deleteStudent(Integer rno) {
        Optional<Student> optionalStudent=studentRepository.findById(rno);
        if(optionalStudent.isPresent()){
            Student dbStudent=optionalStudent.get();
            studentRepository.delete(dbStudent);
            return "Employee deleted successfully";
        }else{
            throw new RuntimeException("Employee not found with given id: "+rno);
        }
    }
}
