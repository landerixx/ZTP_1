package com.Service;

import com.Model.DAO.ZapisanyDao;
import com.Model.Entity.Zapisany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public boolean add(Zapisany entity) {

        boolean result=false;

        if(entity!=null &&!getAllIndexes().contains(new Pair<Integer>(entity.getKursId(),entity.getStudentId()))) {
            zapisanyDao.addZapisany(entity);
            result=true;
        }
        else
            System.err.println("Błąd. Nie można wprowadzić tej encji Zapisany do bazy");

        return result;
    }


    public boolean update(Zapisany entity) {
        System.out.println("update zapisany, puste");
        return false;
    }


    public boolean remove(Zapisany entity) {

        boolean result=false;

        if(entity!=null &&getAllIndexes().contains(new Pair<Integer>(entity.getKursId(),entity.getStudentId()))) {
            zapisanyDao.deleteZapisany(entity.getKursId(), entity.getStudentId());
            result =true;
        }
        else
            System.err.println("Nie istnieje  zapisany w bazie z takimi ID");

        return result;
    }




    public List<Pair<Integer>> getAllIndexes() {

        List<Zapisany> zapisanyList = this.getAll();
        List<Pair<Integer>> zapisanyIdList = new ArrayList<Pair<Integer>>();
        for(Zapisany zapisany: zapisanyList)
            zapisanyIdList.add(new Pair<Integer>(zapisany.getKursId(),zapisany.getKursId()));

        return zapisanyIdList;
    }

    public boolean deleteAllZapisanyStudent(int studentId) {
        boolean result =false;

        Set<Integer> studentsIdSet = getIds(true);

        if(studentsIdSet.contains(studentId)){
            zapisanyDao.deleteAllZapisany(studentId,true);
            result=true;
        }
        else
            System.err.println("Nie istnieje  Student/Zapisany w bazie z takim ID");
        return result;
    }


    public boolean deleteAllZapisanyKurs(int kursId) {

        boolean result =false;

        Set<Integer> coursesIdSet = getIds(false);

        if(coursesIdSet.contains(kursId)){
            zapisanyDao.deleteAllZapisany(kursId,false);
            result=true;
        }
        else
            System.err.println("Nie istnieje  KURS/Zapisany w bazie z takim ID");
        return result;
    }





    /**
     *
     * @param whichOne True-> studentsId, kursId otherwise
     * @return
     */
    private Set<Integer> getIds(boolean whichOne){

        List<Pair<Integer>> zapisanyIdList=getAllIndexes();
        Set<Integer> idSet = new HashSet<Integer>();
        for(Pair<Integer> tuple: zapisanyIdList) {
            if(whichOne)
                idSet.add(tuple.p2);
            else
                idSet.add(tuple.p1);
        }

        return idSet;
    }








}
