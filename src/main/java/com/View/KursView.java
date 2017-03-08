package com.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Piotrek on 2017-03-07.
 */
public class KursView {


    private void inKursView(){

        System.out.println("            ============");
        System.out.println("            ==KursView==");
        System.out.println("            ============");

    }



    public void addedKurs(int kursId, String name){

        inKursView();
        System.out.println("Kurs zostal dodany do bazy. Id kursu: " + kursId + ", nazwa kursu: " + name);

    }

    public void displayAllCourses(HashMap<Integer,String> map){

        inKursView();

        System.out.println("LISTA WSZYSTKICH KURSOW");
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Kurs nr: " + entry.getKey() + " oraz jego nazwa: "+ entry.getValue());

        }
    }// public void displayAllCourses(HashMap<Integer,String> map)

    public void displayCourse(int kursId, String name){

        inKursView();
        System.out.println("Kurs: Id kursu " + kursId + " oraz jego nazwa: " + name);
    }


    public void displayUpdatedCourse(int kursId, String newName){

        inKursView();
        System.out.println("Kurs o indeksie: " + kursId + " zostal zupdatowany. Jego nowa nazwa to:  " +  newName);

    }




}//public class KursView
