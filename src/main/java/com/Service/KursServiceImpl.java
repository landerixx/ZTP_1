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
            System.err.println("Błąd. Nie ma Kursu O PODANYM ID: " + id);
        return null;
    }


    public void add(Kurs entity) {

        if(entity!=null && !getAllIndexes().contains(entity.getKursId()))
            kursDao.addKurs(entity);
        else
            System.err.println("Bład. Nie można dodać tego kursu do bazy");

    }

    public void update(Kurs entity) {

        if(entity!=null && getAllIndexes().contains(entity.getKursId()))
            kursDao.updateKurs(entity);
        else
            System.err.println("Błąd. W BAZIE NIE ISTNIEJE STUDENT O TAKIM ID");
    }

    public void remove(Kurs entity) {

        if(entity!=null && getAllIndexes().contains(entity.getKursId()))
            kursDao.deleteKurs(entity.getKursId());
        else
            System.err.println("Błąd. Nie istnieje  Kurs w bazie z takim ID");
    }



    public List<Integer> getAllIndexes() {

        List<Kurs> courses = this.getAll();
        List<Integer> coursesIdList = new ArrayList<Integer>();
        for(Kurs kurs: courses)
            coursesIdList.add(kurs.getKursId());

        return coursesIdList;

    }
}
