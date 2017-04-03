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



// w serwisie null pointer exception, ze wzgledu na brak pliku


STARAJMY SIE WALIDOWAC JAK NAJWCZESNIEJ!!
*/



public class App 
{
    public static void main( String[] args ) {

        System.out.println( "Hello World!" );
        application();



    }


    //APPKA
    //Use the Controllers methods to demonstrate MVC design pattern usage.
    public static void application(){

    //inicjalizacja



    //DAO
        KursDao kursDao  = new KursDaoImpl();
        StudentDao studentDao = new StudentDaoImpl();
        ZapisanyDao zapisanyDao = new ZapisanyDaoImpl();

        KursDao kursDaoXML = new KursDaoXML();
        StudentDao studentDaoXML = new StudentDaoXML();
        ZapisanyDao zapisanyDaoXML = new ZapisanyDaoXML();

     //SERVICES
        KursService kursService = new KursServiceImpl(kursDao);
        StudentService studentService = new StudentServiceImpl(studentDao);
        ZapisanyService zapisanyService = new ZapisanyServiceImpl(zapisanyDao);

        KursService kursServiceXML = new KursServiceImpl(kursDaoXML);
        StudentService studentServiceXML = new StudentServiceImpl(studentDaoXML);
        ZapisanyService zapisanyServiceXML = new ZapisanyServiceImpl(zapisanyDaoXML);


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

        KursController kursControllerXML = new KursControllerImpl(kursServiceXML,kursView,zapisanyServiceXML,studentServiceXML,studentView);
        StudentController studentControllerXML = new StudentControllerImpl(studentServiceXML,studentView,zapisanyServiceXML,kursServiceXML,kursView);


        //AppController appController = new AppController(kursController,studentController,appView);
        AppController appController= new AppController(kursController,studentController,appView,kursControllerXML,studentControllerXML);

        appController.Application();

    }// public void application()

}
