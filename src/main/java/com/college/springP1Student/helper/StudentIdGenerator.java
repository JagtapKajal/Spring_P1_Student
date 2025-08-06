package com.college.springP1Student.helper;

import com.college.springP1Student.entity.Student;

public class StudentIdGenerator {

    public static String GenerateId(Student student) {


        String fName = student.getfName();
        String lName = student.getlName();
        int yearOfBirth = student.getYearOfBirth();

        char lastName = lName.charAt(0);

        int year = yearOfBirth % 100;

        String str = lastName + fName + year;

        return str;
    }
}
