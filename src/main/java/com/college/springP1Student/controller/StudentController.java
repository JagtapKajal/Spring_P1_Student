package com.college.springP1Student.controller;

import com.college.springP1Student.entity.Student;
import com.college.springP1Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private StudentService studentService; // <-- This is the instance

    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        System.err.println(student);
        studentService.saveStudent(student); // <-- Call on instance
        return new ResponseEntity<>("Student data saved", HttpStatus.CREATED);
    }

    //Create method to get All Students

    @GetMapping("/getStudents")
    public ResponseEntity<List<Student>> getAllStudents() {

        List<Student> studentlist = studentService.getAllStudent();
        return new ResponseEntity<>(studentlist, HttpStatus.OK);
    }
}
