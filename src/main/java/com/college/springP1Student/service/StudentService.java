package com.college.springP1Student.service;

import com.college.springP1Student.entity.Student;
import org.springframework.http.ResponseEntity;


public interface StudentService {

  public String saveStudent(Student student);
}
