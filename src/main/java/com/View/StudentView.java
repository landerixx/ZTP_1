package com.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Piotrek on 2017-03-07.
 */
public class StudentView {

    private void inStudentView(){

        System.out.println("            +++++++++++++++");
        System.out.println("            ++StudentVIEW++");
        System.out.println("            +++++++++++++++");

    }



    public void addedStudent(int studentId, String name){

        inStudentView();
        System.out.println("Student zostal dodany do bazy. Id kursu: " + studentId + ", nazwa studenta: " + name);

    }//  public void addedStudent(int studentId, String name)


    public void showAllCourses(HashMap<Integer,String> map){

        inStudentView();

        System.out.println("LISTA WSZYSTKICH STUDENTOW");
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Student nr: " + entry.getKey() + " oraz jego nazwa: "+ entry.getValue());

        }
    }//    public void showAllCourses(HashMap<Integer,String> map)




    public void showUpdatedStudent(int studentId, String newName){

        inStudentView();
        System.out.println("Student o indeksie: " + studentId + " zostal zupdatowany. Jego nowa nazwa to:  " +  newName);

    }// public void showUpdatedStudent(int studentId, String newName)


    public void showStudent(int studentId, String name){

        System.out.println("Student: Id studenta " + studentId + " oraz jego nazwa: " + name);
    }



}
