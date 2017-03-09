package com.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Piotrek on 2017-03-07.
 */
public class KursView {


    private void inKursView(){

        /*
        System.out.println("            ============");
        System.out.println("            ==KursView==");
        System.out.println("            ============");
        */
    }



    public void addedKurs(int kursId, String name){

        inKursView();
        System.out.println("Kurs zostal dodany do bazy. Id kursu: " + kursId + ", nazwa kursu: " + name);

    }

    public void showAllCourses(HashMap<Integer,String> map){

        inKursView();

        System.out.println("LISTA WSZYSTKICH KURSOW");
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Kurs nr: " + entry.getKey() + " oraz jego nazwa: "+ entry.getValue());

        }
    }// public void showAllCourses(HashMap<Integer,String> map)

    public void showCourse(int kursId, String name){


        System.out.println("Kurs: Id kursu " + kursId + " oraz jego nazwa: " + name);
    }


    public void showUpdatedCourse(int kursId, String newName){

        inKursView();
        System.out.println("Kurs o indeksie: " + kursId + " zostal zupdatowany. Jego nowa nazwa to:  " +  newName);

    }

    public void showCourseWithStudents(){

        System.out.println("Zapisani studenci na ten kurs:");
    }

    public void showMessageNoStudents(){

        System.out.println("->Brak studentow w tym kursie");
    }


    public void cancelStudentMessage(int studentId, String studentName, int kursId, String kursName) {
        System.out.println("Z kursu o ID " + kursId + " o nazwie " + kursName + " zostal wypisany student: " + studentName + " o id " + studentId);

    }

    public void removeFromAllCoursesMessage(int kursId, String kursName) {
        System.out.println("Kurs o id: " +kursId + " i nazwie "+ kursName + ", wszyscy studenci zostali z niego wypisani");
    }

    public void removeCoursePositiveMessage(int kursId, String kursName) {

        System.out.println("Kurs o id: " +kursId + " i nazwie "+ kursName + " zostal usuniety z bazy");
    }

    public void removeCourseNegativeMessage(int kursId, String kursName) {

        System.out.println("Kurs o id: " +kursId + " i nazwie "+ kursName + " nie moze zostac usuniety z bazy. Sa zapisani na niego studenci");
    }

    public void showPromptMessageForKursIndex() {
        System.out.println("Podaj nr indeksu kursu");
    }

    public void showPromptMessageForKursName() {
        System.out.println("Podaj nazwe kursu");
    }
}//public class KursView
