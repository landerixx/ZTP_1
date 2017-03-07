package com.Service;

import com.Model.Entity.Student;
import com.Model.Entity.Zapisany;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Piotrek on 2017-03-07.
 */
public interface ZapisanyService {


    public List <Zapisany> getAll();
    public Zapisany get(int kursId, int studentId );
    public void add(Zapisany entity);
    public void update(Zapisany entity);
    public void remove(Zapisany entity);



    public List<Pair<Integer>> getAllIndexes();}


class Pair<T> {
    T p1, p2;
    Pair(T p1, T p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}