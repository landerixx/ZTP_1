package com.Service;

import com.Model.Entity.Kurs;
import com.Model.Entity.Student;

import java.util.List;

/**
 * Created by Piotrek on 2017-03-07.
 */
public interface KursService {

    public List<Kurs> getAll();
    public Kurs get(int id);
    public void add(Kurs entity);
    public void update(Kurs entity);
    public void remove(Kurs entity);

    public List<Integer> getAllIndexes();



}
