package com.Controller;

import com.Model.Entity.Kurs;
import com.Model.Entity.Student;
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

        kursView.allCourses(map);

    }//  public void displayCourses()



}
