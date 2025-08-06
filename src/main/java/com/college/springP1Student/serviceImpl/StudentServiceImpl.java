package com.college.springP1Student.serviceImpl;

import com.college.springP1Student.entity.Student;
import com.college.springP1Student.helper.StudentIdGenerator;
import com.college.springP1Student.repository.StudentRepository;
import com.college.springP1Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    //To save student details
    @Override
    public String saveStudent(Student student) {

        // call method from generator class to get studentId
        String stu = StudentIdGenerator.GenerateId(student);
        student.setStudentId(stu);

        Student saveStudent = studentRepository.save(student);
        return "Hello " + saveStudent.getfName() + " Your id is: " + saveStudent.getStudentId();
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

    // Delete Student By id
    @Override
    public String DeleteById(int id) {
        studentRepository.deleteById(id);
        return "Student Deleted ";
    }

    // method to Update Student
    @Override
    public Student updateStudent(int id, Student newDetails) {
        Student student = studentRepository.findById(id).orElseThrow(()
                -> new NullPointerException("Id is not found" + id));

        student.setfName(newDetails.getfName());
        student.setlName(newDetails.getlName());
        student.setCity(newDetails.getCity());
        student.setPhone(newDetails.getPhone());

        Student updatestudent = studentRepository.save(student);
        return updatestudent;
    }

    //method to save list of student
    @Override
    public void saveAllStudents(List<Student> student) {
        studentRepository.saveAll(student);

    }

    @Override
    public List<Student> filterStudentByCity(String city) {
        List<Student> studentlist = studentRepository.findAll();

        List<Student> filterList = studentlist.stream().filter(student ->
                student.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        return filterList;
    }
}
