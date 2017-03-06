package com.Model.DAO;

import com.Model.Entity.Student;

import java.util.List;

/**
 * Created by Piotrek on 2017-03-06.
 */
public interface StudentDao {

    public List<Student> getAllStudents();

    public void addStudent(Student student);

    public Student getStudent(int studentId);

    public void updateStudent (Student student);

    public void deleteStudent(int studentId);

}
