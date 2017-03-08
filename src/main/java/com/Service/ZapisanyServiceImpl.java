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
            System.err.println("Błąd. Nie można wprowadzić tej encji Zapisany do bazy. NULL lub zapisany istnieje juz w bazie");

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
            zapisanyIdList.add(new Pair<Integer>(zapisany.getKursId(),zapisany.getStudentId()));

        return zapisanyIdList;
    }


    //TRUE
    public boolean deleteAllZapisanyCoursesFromStudent(int studentId) {
        boolean result =false;

        Set<Integer> coursessIdSet = getIds(studentId,true);

        if(!coursessIdSet.isEmpty()){
            zapisanyDao.deleteAllZapisany(studentId,true);
            result=true;
        }
        else
            System.err.println("Nie istnieje  student, ktory zapisal sie na jakies kursy w bazie z takim ID studenta");
        return result;
    }

    //FALSE
    public boolean deleteAllZapisanyStudentsFromKurs(int kursId) {

        boolean result =false;

        Set<Integer> studentsIdSet = getIds(kursId,false);

        if(!studentsIdSet.isEmpty()){
            zapisanyDao.deleteAllZapisany(kursId,false);
            result=true;
        }
        else
            System.err.println("Nie istnieje  KURS, na ktory zapisali sie jacys studenci w bazie z takim ID kursu");
        return result;
    }





    /**
     * TRUE -> DOSTAJEMY KURSY
     * FALSE -> DOSTAJEMY STUDENTOW
     *
     *INDEKSY WSZYSTKICH STUDENTOW zapisanych na KURS o indeksie ID  GDY FALSE
     * LUB
     * INDEKSY WSZYSTKICH KURSOW na ktore zapisal sie STUDENT o indeksie ID GDY TRUE
     * @param whichOne True-> studentsId, kursId otherwise
     * @return
     */
    public Set<Integer> getIds(int ID,boolean whichOne){

        List<Pair<Integer>> zapisanyIdList=getAllIndexes();
        Set<Integer> idSet = new HashSet<Integer>();
        for(Pair<Integer> tuple: zapisanyIdList) {
            if(!whichOne) {
                if(ID==tuple.kursId)
                    idSet.add(tuple.studentId);
            }
            else{
                if(ID==tuple.studentId)
                idSet.add(tuple.kursId);
            }

        }

        return idSet;
    }








}
