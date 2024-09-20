package com.a2z.demo.service;

import com.a2z.demo.controller.Employee;
import com.a2z.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IEmployeeServiceImpl implements IEmployeeService {
    private final EmployeeRepository employeeRepository;
    List<Employee> employeeList=new ArrayList<>();

    public IEmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployee(Integer id) {
//        Optional<Employee> employee= employeeList.stream()
//                .filter(emp->emp.getId().equals(id)).findFirst();
//        if(employee.isPresent()) {
//            return employee.get();
//        } else {
//            throw new RuntimeException("Employee not found with given id"+id);
//        }
        Optional<Employee> optionalEmployee=employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }else{
            throw new RuntimeException("Employee not found with given id: "+id);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public String createEmployee(Employee employee) {
        Employee employee1=new Employee(employee.getId(),employee.getName(),employee.getAge(),employee.getGender(),employee.getDepartment());
        employeeRepository.save(employee1);
        //employeeList.add(employee);
        return "Employee created successfully";
    }

    @Override
    public String updateEmployee(Employee employee) {
        Optional<Employee> optionalEmployee=employeeRepository.findById(employee.getId());
        if(optionalEmployee.isPresent()){
            Employee dbEmployee=optionalEmployee.get();
            dbEmployee.setName(employee.getName());
            employeeRepository.save(dbEmployee);
            return "Employee updated successfully";
        }else{
            throw new RuntimeException("Employee not found with given id: "+employee.getId());
        }
       // return "Employee updated successfully";
    }

    @Override
    public String deleteEmployee(Integer id) {
        Optional<Employee> optionalEmployee=employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee dbEmployee=optionalEmployee.get();
            employeeRepository.delete(dbEmployee);
            return "Employee deleted successfully";
        }else{
            throw new RuntimeException("Employee not found with given id: "+id);
        }
        //return "Employee deleted successfully";
    }

}
