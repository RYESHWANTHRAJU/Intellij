package com.a2z.demo.service;
import com.a2z.demo.controller.Employee;
import java.util.*;
public interface IEmployeeService
{
    Employee getEmployee(Integer id);
    List<Employee> getAllEmployees();
    String createEmployee(Employee employee);
    String updateEmployee(Employee employee);
    String deleteEmployee(Integer id);
}
