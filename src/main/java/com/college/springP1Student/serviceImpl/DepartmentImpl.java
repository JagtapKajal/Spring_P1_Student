package com.college.springP1Student.serviceImpl;

import com.college.springP1Student.entity.Department;
import com.college.springP1Student.repository.DepartmentRepository;
import com.college.springP1Student.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDep(Department department) {
        return DepartmentRepository.save(department);
    }
}
