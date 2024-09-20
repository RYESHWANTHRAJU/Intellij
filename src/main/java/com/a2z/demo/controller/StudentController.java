package com.a2z.demo.controller;

import com.a2z.demo.model.Student;
import com.a2z.demo.service.IStudentservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    private final IStudentservice iStudentservice;

    public StudentController(IStudentservice iStudentservice) {
        this.iStudentservice = iStudentservice;
    }

    @GetMapping("all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(iStudentservice.getAllStudents());
    }
    @GetMapping("{rno}")
    public ResponseEntity<Student> getStudent(@PathVariable Integer rno) {
        return ResponseEntity.ok(iStudentservice.getStudent(rno));

    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(iStudentservice.createStudent(student));
    }

    @PutMapping
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
        return ResponseEntity.ok(iStudentservice.updateStudent(student));
    }

    @DeleteMapping("{rno}")
    public ResponseEntity<String> deleteStudent(@PathVariable("rno") Integer rno) {
        return ResponseEntity.ok(iStudentservice.deleteStudent(rno));
    }

}
