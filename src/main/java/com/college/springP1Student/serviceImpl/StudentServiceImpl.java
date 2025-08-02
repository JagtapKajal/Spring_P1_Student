package com.college.springP1Student.serviceImpl;

import com.college.springP1Student.entity.Student;
import com.college.springP1Student.repository.StudentRepository;
import com.college.springP1Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    //To save student details
    @Override
    public String saveStudent(Student student) {

        Student saveStudent = studentRepository.save(student);
        return "Student saved";
    }

    //Display all saved Student
    @Override
    public List<Student> getAllStudent() {

        List<Student> studentlist = studentRepository.findAll();
        return studentlist;
    }

    // Get Student By Id
    @Override
    public Student getStudentById(int id) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.orElse(null);
    }
}
