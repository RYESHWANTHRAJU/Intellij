package com.a2z.demo.controller;
import com.a2z.demo.service.IEmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController
{
    private final IEmployeeService iEmployeeService;
    public EmployeeController(IEmployeeService iEmployeeService)
    {
        this.iEmployeeService=iEmployeeService;
    }
    @GetMapping("all")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        return ResponseEntity.ok(iEmployeeService.getAllEmployees());
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id)
    {
            return ResponseEntity.ok(iEmployeeService.getEmployee(id));
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee)
    {
        return ResponseEntity.ok(iEmployeeService.createEmployee(employee));
    }

    @PutMapping
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee)
    {
        return ResponseEntity.ok(iEmployeeService.updateEmployee(employee));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id)
    {
        return ResponseEntity.ok(iEmployeeService.deleteEmployee(id));
    }

}
