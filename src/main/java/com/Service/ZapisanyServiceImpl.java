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
            System.err.println("Błąd. Nie ma encji Zapisany O PODANYCH ID kursId: "+kursId + "oraz studentID: "+ studentId );

        return null;
    }

    public void add(Zapisany entity) {

        if(entity!=null &&!getAllIndexes().contains(new Pair<Integer>(entity.getKursId(),entity.getStudentId())))
            zapisanyDao.addZapisany(entity);
        else
            System.err.println("Błąd. Nie można wprowadzić tej encji Zapisany do bazy");
    }


    public void update(Zapisany entity) {
        System.out.println("update zapisany, puste");
    }


    public void remove(Zapisany entity) {

        if(entity!=null &&getAllIndexes().contains(new Pair<Integer>(entity.getKursId(),entity.getStudentId())))
            zapisanyDao.deleteZapisany(entity.getKursId(),entity.getStudentId());
        else
            System.err.println("Nie istnieje  zapisany w bazie z takimi ID");
    }




    public List<Pair<Integer>> getAllIndexes() {

        List<Zapisany> zapisanyList = this.getAll();
        List<Pair<Integer>> zapisanyIdList = new ArrayList<Pair<Integer>>();
        for(Zapisany zapisany: zapisanyList)
            zapisanyIdList.add(new Pair<Integer>(zapisany.getKursId(),zapisany.getKursId()));

        return zapisanyIdList;
    }

    public boolean deleteAllZapisanyStudent(int studentId) {
        return false;
    }

    public boolean deleteAllZapisanyKurs(int kursId) {
        return false;
    }
}
