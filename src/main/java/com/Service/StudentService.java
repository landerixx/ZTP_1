package com.Service;

import com.Model.Entity.Student;

import java.util.List;

/**
 * Created by Piotrek on 2017-03-07.
 */
public interface StudentService {


    public List<Student> getAll();
    public Student get(int id);
    public void add(Student entity);
    public void update(Student entity);
    public void remove(Student entity);

    public List<Integer> getAllIndexes();


}
