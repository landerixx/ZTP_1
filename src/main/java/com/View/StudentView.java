package com.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Piotrek on 2017-03-07.
 */
public class StudentView {

    private void inStudentView(){
/*
        System.out.println("            +++++++++++++++");
        System.out.println("            ++StudentVIEW++");
        System.out.println("            +++++++++++++++");
*/
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


    public void showStudentWithCourses() {
        System.out.println("Kursy tego studenta:");
    }

    public void showMessageNoCourses() {
        System.out.println("->Brak kursow tego studenta");
    }

    public void showEnroll(int studentId, String studentName, int kursId, String kursName) {
        inStudentView();
        System.out.println("ZAPISALES STUDENTA " + studentName+ " o ID " + studentId + " na kurs " +kursName+  " o ID " + kursId);
    }

    public void showRemoveFromCourseMessage(int studentId, String studentName, int kursId, String kursName) {

        System.out.println("STUDENT " + studentId + " o nazwie " + studentName + " zostal wypisany z kursu: " + kursName);
    }

    public void removeFromAllCoursesMessage(int studentId, String studentName) {

        System.out.println("Student o id: " +studentId + " i nazwie "+ studentName + " zostal wypisany z wszystkich kursow");
    }

    public void removeStudentPositiveMessage(int studentId, String studentName) {

        System.out.println("Student o id: " +studentId + " i nazwie "+ studentName + " zostal usuniety z bazy");
    }

    public void removeStudentNegativeMessage(int studentId, String studentName){

        System.out.println("Student o id: " +studentId + " i nazwie "+ studentName + " nie moze zostac usuniety z bazy. Jest zapisany na kursy");
    }

    public  void showPromptMessageForStudentIndex() {
        System.out.println("Podaj nr indeksu studenta");
    }


    public void showPromptMessageForStudentName() {
        System.out.println("Podaj nazwe studenta");
    }

    public void validationTestName(String name) {
        if(name!=null)
            System.out.println( "Nazwa nie spelnia kryteriow, posiada cyfry");
    }
}
