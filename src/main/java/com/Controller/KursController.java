package com.Controller;

import com.Model.Entity.Kurs;
import com.Service.KursService;
import com.View.KursView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Piotrek on 2017-03-07.
 */
public class KursController {

    private KursService kursService;
    private KursView kursView;

    public KursController(){};

    public KursController(KursService kursService, KursView kursView){

        this.kursService=kursService;
        this.kursView=kursView;
    }



   public  boolean createKurs(int kursId, String name){

        boolean result=false;

        result = kursService.add(new Kurs(kursId,name));

        if(result)
            kursView.addedKurs(kursId,name);

        return result;
    }// public  boolean createKurs(int kursId, String name)


    public void displayCourses(){


        List<Kurs> courseList=kursService.getAll();
        HashMap<Integer,String> map= new HashMap<Integer, String>();
        for(Kurs kurs: courseList)
            map.put(kurs.getKursId(),kurs.getKursName());

        kursView.displayAllCourses(map);

    }//  public void displayCourses()

    public boolean displayCourse(int kursId){

        boolean result=false;

        Kurs kurs = kursService.get(kursId);
        if(kurs!=null){
            result=true;
            kursView.displayCourse(kursId,kurs.getKursName());

        }

        return result;

    }// public void displayCourse(int kursId, String name)




    public boolean changeCourseName(int kursId, String newName){

        boolean result =false;
        result = kursService.update(new Kurs(kursId,newName));

        if(result)
            kursView.displayUpdatedCourse(kursId,newName);

        return result;

    }//public boolean changeCourseName(int kursId, String newName)






}
