package com.Model.DAO;

import com.Model.Entity.Zapisany;

import java.util.List;

/**
 * Created by Piotrek on 2017-03-06.
 */
public interface ZapisanyDao {


    public List<Zapisany> getAllZapisany();

    public void addZapisany(Zapisany zapisany);

    public Zapisany getZapisany(int kursId,int studentId);

    public void updateZapisany (Zapisany zapisany);

    public void deleteZapisany(int kursId,int studentId);

}
