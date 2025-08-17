package com.college.springP1Student.serviceImpl;

import com.college.springP1Student.entity.Employee;
import com.college.springP1Student.repository.EmployeeRepository;
import com.college.springP1Student.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found with " + id ));
    }
}
