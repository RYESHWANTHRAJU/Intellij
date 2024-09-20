//package com.a2z.demo.controller;
//import com.a2z.demo.controller.Employee;
//import org.springframework.http.ResponseEntity;//It represents the entire http response including status, header and body
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController //It handles the http requests
//@RequestMapping("api")
//public class Controller2 {
//    List<Employee> employees = new ArrayList<>();
//   /* @GetMapping("employees/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
//        // Logic to retrieve the employee with the given id
//        Employee employee = new Employee(id, "John Doe", 30, "Male", "IT", 2020, 50000.0);
//        return ResponseEntity.ok(employee);
//    }*/
//
//    @GetMapping("employees")
//    public ResponseEntity<List<Employee>> getAllEmployees() {
//        // Logic to retrieve all employees
//        // List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(1, "John Doe", 30, "Male", "IT", 2020, 50000.0));
//        employees.add(new Employee(2, "Jane Smith", 28, "Female", "HR", 2019, 55000.0));
//        return ResponseEntity.ok(employees);
//    }
//
//    @PostMapping("employees")
//    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
//        // Logic to save the employee
//         employees.add(employee);
//        return ResponseEntity.ok("Employee created successfully");
//    }
//
//    @PutMapping("employees/{id}")
//    public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
//        // Logic to update the employee with the given id
//        return ResponseEntity.ok("Employee updated successfully");
//    }
//
//    @DeleteMapping("employees/{id}")
//    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
//        // Logic to delete the employee with the given id
//        return ResponseEntity.ok("Employee deleted successfully");
//    }
//}
//
