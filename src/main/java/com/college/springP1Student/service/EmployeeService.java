package com.college.springP1Student.service;

import com.college.springP1Student.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    // To add/save Employee
    Employee saveEmp(Employee employee);

    Employee getById(int id);

    public List<Employee> getAllEmp();

    public String DeleteById(int id);

}
