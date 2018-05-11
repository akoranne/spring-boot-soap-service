package com.developer.soapservice.repository;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

import com.developer.xml.generated.Student;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class StudentRepository {
    private static final Map<String, Student> students = new HashMap<>();

    @PostConstruct
    public void initData() {

        Student student = new Student();
        student.setName("Sajal");
        student.setGrade(5);
        student.setAddress("Pune");
        students.put(student.getName(), student);

        student = new Student();
        student.setName("Kajal");
        student.setGrade(5);
        student.setAddress("Chicago");
        students.put(student.getName(), student);

        student = new Student();
        student.setName("Lokesh");
        student.setGrade(6);
        student.setAddress("Delhi");
        students.put(student.getName(), student);

        student = new Student();
        student.setName("Sukesh");
        student.setGrade(7);
        student.setAddress("Noida");
        students.put(student.getName(), student);
    }

    public Student findStudent(String name) {
        Assert.notNull(name, "The Student's name must not be null");
        return students.get(name);
    }
}

