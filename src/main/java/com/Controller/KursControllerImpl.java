package com.Controller;

import com.Model.Entity.Kurs;
import com.Model.Entity.Student;
import com.Service.KursService;
import com.Service.StudentService;
import com.Service.ZapisanyService;
import com.View.KursView;
import com.View.StudentView;

import java.util.HashMap;
import java.util.List;
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

        boolean result=displayCourse(kursId);

        kursView.showCourseWithStudents();

        Set<Integer> studentIDs= zapisanyService.getIds(kursId,false); //true -> wyciagniemy wszystkich studentow
        Student stud;
        System.out.println(studentIDs);
        for(Integer id: studentIDs) {

            stud = studentService.get(id);
            studentView.showStudent(id,stud.getStudentName());
        }

        return result;

    }//  public boolean displayCourseWithStudents(int kursId)


}
