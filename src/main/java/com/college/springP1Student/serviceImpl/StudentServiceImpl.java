package com.college.springP1Student.serviceImpl;

import com.college.springP1Student.entity.Student;
import com.college.springP1Student.repository.StudentRepository;
import com.college.springP1Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String saveStudent(Student student) {

        Student saveStudent = StudentRepository.save(Student);
        return "Student saved";
    }
}
