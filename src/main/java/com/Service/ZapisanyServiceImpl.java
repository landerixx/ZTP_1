package com.Service;

import com.Model.DAO.ZapisanyDao;
import com.Model.Entity.Zapisany;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotrek on 2017-03-07.
 */
public class ZapisanyServiceImpl implements ZapisanyService  {


    private ZapisanyDao zapisanyDao;

    public ZapisanyServiceImpl(ZapisanyDao zapisanyDao){
        this.zapisanyDao=zapisanyDao;
    }

    public List<Zapisany> getAll() {

       return zapisanyDao.getAllZapisany();
    }



    public Zapisany get(int kursId, int studentId) {

        if (getAllIndexes().contains(new Pair<Integer>(kursId,studentId)))
            return zapisanyDao.getZapisany(kursId,studentId);
        else
            System.out.println("NIE MA Zapisany O PODANYCH ID");

        return null;
    }

    public void add(Zapisany entity) {

        if(!getAllIndexes().contains(new Pair<Integer>(entity.getKursId(),entity.getStudentId())))
            zapisanyDao.addZapisany(entity);
        else
            System.out.println("W bazie jest juz zapisany z takimi ID, nie mozna dodac");
    }


    public void update(Zapisany entity) {
        System.out.println("PUSTE");
    }


    public void remove(Zapisany entity) {

        if(getAllIndexes().contains(new Pair<Integer>(entity.getKursId(),entity.getStudentId())))
            zapisanyDao.deleteZapisany(entity.getKursId(),entity.getStudentId());
        else
            System.out.println("Nie istnieje  zapisany w bazie z takimi ID");
    }




    public List<Pair<Integer>> getAllIndexes() {

        List<Zapisany> zapisanyList = this.getAll();
        List<Pair<Integer>> zapisanyIdList = new ArrayList<Pair<Integer>>();
        for(Zapisany zapisany: zapisanyList)
            zapisanyIdList.add(new Pair<Integer>(zapisany.getKursId(),zapisany.getKursId()));

        return zapisanyIdList;
    }
}
