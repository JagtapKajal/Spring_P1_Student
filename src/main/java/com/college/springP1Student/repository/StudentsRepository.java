package com.college.springP1Student.repository;

import com.college.springP1Student.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Integer> {
}
