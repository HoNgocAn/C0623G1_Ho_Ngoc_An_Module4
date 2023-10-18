package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository{

    private static List<Student> studentList;

    static {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Nguyễn Văn A"));
        studentList.add(new Student(2, "Nguyễn Văn B"));
        studentList.add(new Student(3, "Nguyễn Văn C"));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }
}
