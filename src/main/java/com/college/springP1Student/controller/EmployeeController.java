package com.college.springP1Student.controller;

import com.college.springP1Student.entity.Employee;
import com.college.springP1Student.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Create User + Profile
    @PostMapping("/addEmp")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmp(employee);
    }

    // Get User by ID (with Profile)
    @GetMapping("/getEmployee/{id}")
    public Employee getById(@PathVariable int id) {
        return employeeService.getById(id);
    }

    // Get All Users
    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmp();
    }

    // Delete User by ID (Profile will also be deleted due to cascade)
    @DeleteMapping("/DeleteEmp/{id}")
    public String deleteById(@PathVariable int id) {
        return employeeService.DeleteById(id);
    }

}
