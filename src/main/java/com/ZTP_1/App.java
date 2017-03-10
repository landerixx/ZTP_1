package com.ZTP_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Controller.*;
import com.Model.DAO.*;
import com.Model.Entity.Kurs;
import com.Model.Entity.Student;
import com.Model.Entity.Zapisany;
import com.Service.*;
import com.View.AppView;
import com.View.KursView;
import com.View.StudentView;

/*

http://www.codesenior.com/en/tutorial/Spring-Generic-DAO-and-Generic-Service-Implementation
A "service layer" exists between the UI and the backend
        systems that store data, and is in charge of managing the business rules of transforming and translating data between those two layers.

        https://www.tutorialspoint.com/design_pattern/mvc_pattern.htm

*/



public class App 
{
    public static void main( String[] args ) {

        System.out.println( "Hello World!" );
        //application();

        /*
        KursDaoXML kursDao =new  KursDaoXML();
        //kursDao.addKurs(new Kurs(5,"dupa4"));
        kursDao.deleteKurs(3);

        List<Kurs> kursy = kursDao.getAllCourses();
        for(Kurs k:kursy)
            System.out.println(k);
       */

        /*

        StudentDao studentDao = new StudentDaoXML();
        //studentDao.addStudent(new Student(162, "adamefranek"));
        Student st=studentDao.getStudent(162);
        System.out.println(st);
        List<Student> lista = studentDao.getAllStudents();
        System.out.println( lista);

        st.setStudentName("poprawiony");
        studentDao.updateStudent(st);

        lista = studentDao.getAllStudents();
        System.out.println( lista);

        studentDao.deleteStudent(12);

        lista = studentDao.getAllStudents();
        System.out.println( lista);

*/


        ZapisanyDao zapisanyDao = new ZapisanyDaoXML();
       // zapisanyDao.addZapisany(new Zapisany(5001,45));
        Zapisany zap = zapisanyDao.getZapisany(1,6);
        System.out.println(zap);
        List<Zapisany> listaz = zapisanyDao.getAllZapisany();
        System.out.println(listaz);

       // zapisanyDao.deleteZapisany(2,2);



        zapisanyDao.deleteAllZapisany(45,true);

        listaz = zapisanyDao.getAllZapisany();
        System.out.println(listaz);
    }


    //APPKA
    //Use the Controllers methods to demonstrate MVC design pattern usage.
    public static void application(){

    //inicjalizacja



    //DAO
        KursDao kursDao  = new KursDaoImpl();
        StudentDao studentDao = new StudentDaoImpl();
        ZapisanyDao zapisanyDao = new ZapisanyDaoImpl();

     //SERVICES
        KursService kursService = new KursServiceImpl(kursDao);
        StudentService studentService = new StudentServiceImpl(studentDao);
        ZapisanyService zapisanyService = new ZapisanyServiceImpl(zapisanyDao);

     //Views
        KursView kursView = new KursView();
        StudentView studentView = new StudentView();
        AppView appView= new AppView();

      //Controllers
        KursController kursController;
        //kursController= new KursControllerImpl(kursService,kursView);
        StudentController studentController;
        //studentController = new StudentControllerImpl(studentService,studentView);

        kursController=new KursControllerImpl(kursService,kursView,zapisanyService,studentService,studentView);
        studentController = new StudentControllerImpl(studentService,studentView,zapisanyService,kursService,kursView);
        AppController appController = new AppController(kursController,studentController,appView);

        appController.Application();

    }// public void application()

}
