package com.college.springP1Student.controller;

import com.college.springP1Student.entity.Employee;
import com.college.springP1Student.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/addEmp")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.saveEmp(employee);
    }

    @GetMapping("/getEmployee/{id}")
    public Employee getById(@PathVariable int id){
        return employeeService.getById(id);
    }
}
