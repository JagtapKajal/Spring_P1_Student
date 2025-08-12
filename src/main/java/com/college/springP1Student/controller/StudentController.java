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
import java.util.stream.Collectors;

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

    //Filter city and gender from database without creating new API
    @GetMapping("/filter")
    public ResponseEntity<List<Student>> filterByCity(@RequestParam(required = false) String city, @RequestParam(required = false) String gender) {

        // List<Student> studentList = studentService.filterStudentByCity(city);

        List<Student> student = studentService.getAllStudent();

        List<Student> filteredList = student;
        List<Student> sortedList = new ArrayList<>();

        if (city != null && gender != null) {
            filteredList = student.stream().filter(stu -> stu.getCity().equalsIgnoreCase(city) && stu.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());
        } else if (city != null) {
            sortedList = studentService.filterStudentByCity(city);
        } else if (gender != null) {
            sortedList = studentService.filterByGender(gender);
        } else {
            return new ResponseEntity<>(student, HttpStatus.BAD_REQUEST);
        }
        if (filteredList.isEmpty()) {
            return new ResponseEntity<>(filteredList, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sortedList, HttpStatus.OK);

    }

    // Delete Student By city
    @DeleteMapping("/deleteByCity/{city}")
    public ResponseEntity<String> deleteByCity(@PathVariable String city) {
        String response = studentService.deleteStudentByCity(city);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // filter by FirstName
    @GetMapping("/filterByfName")
    public ResponseEntity<List<Student>> filterByfName(@RequestParam(required = false) String fName) {
        List<Student> studentsList = studentService.filterByFirstName(fName);
        return new ResponseEntity<>(studentsList, HttpStatus.OK);
    }

    // filter by LastName
    @GetMapping("/filterBylName")
    public ResponseEntity<List<Student>> filterBylName(@RequestParam(required = false) String lName) {
        List<Student> studentsList = studentService.filterByLastName(lName);
        return new ResponseEntity<>(studentsList, HttpStatus.OK);
    }

}
