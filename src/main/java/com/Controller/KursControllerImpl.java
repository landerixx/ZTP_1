package com.Controller;

import com.Model.Entity.Kurs;
import com.Model.Entity.Student;
import com.Model.Entity.Zapisany;
import com.Service.KursService;
import com.Service.StudentService;
import com.Service.ZapisanyService;
import com.View.KursView;
import com.View.StudentView;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Piotrek on 2017-03-07.
 */
public class KursControllerImpl implements KursController {

    private KursService kursService;
    private KursView kursView;

    private ZapisanyService zapisanyService;
    private StudentService studentService;
    private StudentView studentView;
    Scanner scanner;

    public KursControllerImpl(){};

    public KursControllerImpl(KursService kursService, KursView kursView){

        this.kursService=kursService;
        this.kursView=kursView;
           }

    public KursControllerImpl(KursService kursService, KursView kursView, ZapisanyService zapisanyService,
    StudentService studentService, StudentView studentView){


        this.kursService=kursService;
        this.kursView=kursView;
        this.zapisanyService=zapisanyService;
        this.studentService=studentService;
        this.studentView=studentView;



    }

    public void setKursService(KursService kursService) {
        this.kursService = kursService;
    }

    public void setZapisanyService(ZapisanyService zapisanyService) {
        this.zapisanyService = zapisanyService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public int promptForKursIndex(){

        scanner= new Scanner(System.in);
        int kursIndex;
       kursView.showPromptMessageForKursIndex();
        kursIndex=scanner.nextInt();
      //  scanner.close();
        return kursIndex;

    }

    public String promptForKursName(){

        scanner= new Scanner(System.in);
        String kursName;
       kursView.showPromptMessageForKursName();
        kursName = scanner.next();
     //   scanner.close();
        return kursName;
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

        kursView.showAllCourses(map);

    }//  public void displayCourses()

    public boolean displayCourse(int kursId){

        boolean result=false;

        Kurs kurs = kursService.get(kursId);
        if(kurs!=null){
            result=true;
            kursView.showCourse(kursId,kurs.getKursName());

        }

        return result;

    }// public void showCourse(int kursId, String name)




    public boolean changeCourseName(int kursId, String newName){

        boolean result =false;
        result = kursService.update(new Kurs(kursId,newName));

        if(result)
            kursView.showUpdatedCourse(kursId,newName);

        return result;

    }//public boolean changeCourseName(int kursId, String newName)




    //======================================================


    public boolean displayCourseWithStudents(int kursId) {

        boolean result=displayCourse(kursId); //jezeli false nie ma takiego kursu

        kursView.showCourseWithStudents();

        Set<Integer> studentIDs= zapisanyService.getIds(kursId,false); //false -> wyciagniemy wszystkich studentow zapisanych na ten kurs
        Student stud;

        for(Integer id: studentIDs) {

            stud = studentService.get(id);
            studentView.showStudent(id,stud.getStudentName());
        }
        if(studentIDs.isEmpty())
            kursView.showMessageNoStudents();

        return result;

    }//  public boolean displayCourseWithStudents(int kursId)




    //=================================================

    public boolean cancelStudent(int kursId, int studentId) {


        boolean result=false;

        Student stud = studentService.get(studentId);
        Kurs kurs = kursService.get(kursId);


        result=zapisanyService.remove(new Zapisany(kursId,studentId));

        if(result)
           kursView.cancelStudentMessage(studentId, stud.getStudentName(),kursId, kurs.getKursName());


        return result;

    }

    public boolean cancelAllStudents(int kursId) {

        boolean result = false;

        Kurs kurs = kursService.get(kursId);
        boolean isKurs = kurs !=null;

        Set<Integer> studentsIds;
        if(isKurs) {
            studentsIds = zapisanyService.getIds(kursId, false); //false -> wyciagniemy wszystkich studentow tego kursu
            for(Integer studentId: studentsIds)
                zapisanyService.remove(new Zapisany(kursId,studentId));

            result = true;
            kursView.removeFromAllCoursesMessage(kursId,kurs.getKursName());
        }



        return result;

    }

    public boolean removeCourse(int kursId) {

        boolean result = false;

        Kurs kurs = kursService.get(kursId);
        boolean isKurs = kurs !=null;


        Set<Integer> studentsIds;
        if(isKurs) {
            studentsIds = zapisanyService.getIds(kursId, false); //false -> wyciagniemy wszystkich studentow tego kursu


            //jaka strategia -> usuwamy zapisy ze srtudentami, czy powiadamiamy uzytkownika, ze sa zapisani studenci na kurs
            //narazie tylko powiadamiam


            if(studentsIds.isEmpty()) {
                kursService.remove(kurs);
               kursView.removeCoursePositiveMessage(kursId, kurs.getKursName());
                result=true;

            }
            else
                kursView.removeCourseNegativeMessage(kursId, kurs.getKursName());
        }

        return result;
    }


}
