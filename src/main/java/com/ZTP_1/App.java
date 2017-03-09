package com.ZTP_1;

import java.util.Scanner;

import com.Controller.*;
import com.Model.DAO.*;
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
