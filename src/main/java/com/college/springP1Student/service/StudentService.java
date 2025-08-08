package com.college.springP1Student.service;

import com.college.springP1Student.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    public String saveStudent(Student student);

    public List<Student> getAllStudent();

    public Student getStudentById(int id);

    public String DeleteById(int id);

    Student updateStudent(int id, Student newDetails);

    public void saveAllStudents(List<Student> student);

    List<Student> filterStudentByCity(String city);

    List<Student> filterByGender(String gender);



}
