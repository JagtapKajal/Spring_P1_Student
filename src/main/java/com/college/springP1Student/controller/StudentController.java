package com.college.springP1Student.controller;

import com.college.springP1Student.entity.Student;
import com.college.springP1Student.repository.StudentRepository;
import com.college.springP1Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private StudentService studentService; // <-- This is the instance

    //add Students
    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        System.err.println(student);

        String s = studentService.saveStudent(student);
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    //Create method to get All Students
    @GetMapping("/getStudents")
    public ResponseEntity<List<Student>> getAllStudents() {

        List<Student> studentlist = studentService.getAllStudent();
        return new ResponseEntity<>(studentlist, HttpStatus.OK);
    }

    // Get Student By id
    @GetMapping("/getById/{id}")
    public ResponseEntity<Student> getStudentById(int id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Delete Student By id
    @GetMapping("/DeleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        String delete = studentService.DeleteById(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

    //Update Student Details
    @GetMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student student) {
        Student updateStudent = studentService.updateStudent(id, student);
        return new ResponseEntity<>(updateStudent, HttpStatus.OK);
    }

    // save All Students List
    public ResponseEntity<String> getAllStudents(List<Student> student) {
        studentService.saveAllStudents(student);
        return new ResponseEntity<>("Student data saved", HttpStatus.CREATED);
    }

    //Filter city from database
    @GetMapping("/filter")
    public ResponseEntity<List<Student>> filterByCity(@RequestParam(required = false) String city,
                                                     @RequestParam(required = false) String gender) {

       // List<Student> studentList = studentService.filterStudentByCity(city);

        List<Student> sortedList = new ArrayList<>();
        if(city != null){
            sortedList = studentService.filterStudentByCity(city);
        }
        else{
            sortedList = studentService.filterByGender(gender);
        }
        return new ResponseEntity<>(sortedList, HttpStatus.OK);

    }

}
