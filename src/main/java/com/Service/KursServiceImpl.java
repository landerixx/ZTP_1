package com.Service;

import com.Model.DAO.KursDao;
import com.Model.DAO.KursDaoImpl;
import com.Model.Entity.Kurs;
import com.Model.Entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotrek on 2017-03-07.
 */

public class KursServiceImpl implements KursService {

    private KursDao kursDao;

    public KursServiceImpl(KursDao kursDao){

        this.kursDao=kursDao;
    }


    public List<Kurs> getAll() {
        return kursDao.getAllCourses();
    }


    public Kurs get(int id) {

        if(getAllIndexes().contains(id))
            return kursDao.getKurs(id);
        else
            System.out.println("NIE MA Kursu O PODANYM ID");
        return null;
    }


    public void add(Kurs entity) {

        if(!getAllIndexes().contains(entity.getKursId()))
            kursDao.addKurs(entity);
        else
            System.out.println("W bazie jest juz Kurs z takim ID, nie mozna dodac");

    }

    public void update(Kurs entity) {

        kursDao.updateKurs(entity);
    }

    public void remove(Kurs entity) {

        if(getAllIndexes().contains(entity.getKursId()))
            kursDao.deleteKurs(entity.getKursId());
        else
            System.out.println("Nie istnieje  Kurs w bazie z takim ID");
    }



    public List<Integer> getAllIndexes() {

        List<Kurs> courses = this.getAll();
        List<Integer> coursesIdList = new ArrayList<Integer>();
        for(Kurs kurs: courses)
            coursesIdList.add(kurs.getKursId());

        return coursesIdList;

    }
}
