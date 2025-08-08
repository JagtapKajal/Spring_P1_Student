package com.college.springP1Student.repository;

import com.college.springP1Student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByCity(String city);
}
