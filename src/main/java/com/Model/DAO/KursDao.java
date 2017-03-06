package com.Model.DAO;


import com.Model.Entity.Kurs;

import java.util.List;

/**
 * Created by Piotrek on 2017-03-06.
 */
public interface KursDao {

    public List<Kurs> getAllCourses();

    public void addKurs(Kurs kurs);

    public Kurs getKurs(int KursId);

    public void updateKurs(Kurs kurs);

    public void deleteKurs(int KursId);

}
