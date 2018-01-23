package com.example.demo.dao;


import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    private static final Map<String, Student> students = new HashMap<>();

    @PostConstruct
    public void initData() {

        Student student  =  new Student();
        student.setName("Joe");
        student.setAge(24);
        student.setCourse("Computers");
        student.setId(112);
        students.put(student.getName(), student);

        student  =  new Student();
        student.setName("Robin");
        student.setAge(24);
        student.setCourse("Science");
        student.setId(112);
        students.put(student.getName(), student);

    }

    public Student findStudent(String name) {
        Assert.notNull(name, "The Student's name must not be null");
        return students.get(name);
    }

    public int addStudent(Student student) {
        Assert.notNull(student.getName(), "The Student's name must not be null");
        students.put(student.getName(), student);
        return 1;
    }

    public int updateStudentById(String name, Student studentUpdate) {
        Assert.notNull(name, "The Student's name must not be null");
        students.put(studentUpdate.getName(), studentUpdate);
        return 1;
    }

    public int removeStudent(String name) {
        Assert.notNull(name, "The Student's name must not be null");
        students.remove(name);
        return 1;
    }
}