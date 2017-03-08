package com.Service;

import com.Model.Entity.Zapisany;

import java.util.List;
import java.util.Set;

/**
 * Created by Piotrek on 2017-03-07.
 */
public interface ZapisanyService {


    public List <Zapisany> getAll();
    public Zapisany get(int kursId, int studentId );
    public boolean add(Zapisany entity);
    public boolean update(Zapisany entity);
    public boolean remove(Zapisany entity);



    public List<Pair<Integer>> getAllIndexes();

    public boolean deleteAllZapisanyCoursesFromStudent(int studentId);
    public boolean deleteAllZapisanyStudentsFromKurs(int kursId);



    public Set<Integer> getIds(int ID,boolean whichOne);
}


class Pair<T> {
    T kursId, studentId;
    Pair(T kursId, T studentId) {
        this.kursId = kursId;
        this.studentId = studentId;
    }
}