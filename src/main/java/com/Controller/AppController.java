package com.Controller;

import com.Service.KursService;
import com.Service.StudentService;
import com.Service.ZapisanyService;
import com.View.AppView;

import java.util.Scanner;

/**
 * Created by Piotrek on 2017-03-09.
 */
public class AppController {

    private KursController kursController;
    private StudentController studentController;
    private AppView appView;
    Scanner scanner;
    int helper;


    private KursController kursControllerDB;
    private KursController kursControllerXML;

    private StudentController studentControllerDB;
    private  StudentController studentControllerXML;


    //XML OR DB



    public AppController(KursController kursController, StudentController studentController, AppView appView) {
        this.kursController = kursController;
        this.studentController = studentController;
        this.appView=appView;
    }

    public AppController(KursController kursController, StudentController studentController, AppView appView, KursController kursControllerXML, StudentController studentControllerXML) {

        this(kursController,studentController,appView);

        this.kursControllerDB = kursController;
        this.studentControllerDB = studentController;

        this.kursControllerXML=kursControllerXML;
        this.studentControllerXML=studentControllerXML;
    }






 public void Application(){

     scanner = new Scanner(System.in);

     appView.showHello();
     appView.showAllFunctionalities();
     helper=0;

    int studentId;
    String studentName;
     int kursId;
     String kursName;


     while (helper!=100){

         helper = scanner.nextInt();

        switch(helper){

            case 0:
                appView.showAllFunctionalities();
                break;

            case 1:
                appView.showCreateStudent();
                studentId=studentController.promptForStudentIndex();
                studentName=studentController.promptForStudentName();
                studentController.createStudent(studentId,studentName);
                break;

            case 2:
                appView.showCreateCourse();
                kursId=kursController.promptForKursIndex();
                kursName=kursController.promptForKursName();
                kursController.createKurs(kursId,kursName);
                break;

            case 3:
                appView.showEnrollStudentForCourse();
                studentId=studentController.promptForStudentIndex();
                kursId=kursController.promptForKursIndex();
                studentController.enrollStudentforCourse(studentId,kursId);
                break;
            case 4:
                appView.showAllStudents();
                studentController.displayAllStudents();
                break;
            case 5:
                appView.showAllCourses();
                kursController.displayCourses();
                break;
            case 6:
                appView.showStudent();
                studentId=studentController.promptForStudentIndex();
                studentController.displayStudent(studentId);
                break;
            case 7:
                appView.showCourse();
                kursId=kursController.promptForKursIndex();
                kursController.displayCourse(kursId);
                break;
            case 8:
                appView.showStudentWithCourses();
                studentId=studentController.promptForStudentIndex();
                studentController.displayStudentWithCourses(studentId);
                break;
            case 9:
                appView.showCourseWithStudents();
                kursId=kursController.promptForKursIndex();
                kursController.displayCourseWithStudents(kursId);
                break;
            case 10:
                appView.showUpdateStudentsName();
                studentId=studentController.promptForStudentIndex();
                studentName=studentController.promptForStudentName();
                studentController.changeStudentName(studentId,studentName);
                break;
            case 11:
                appView.showUpdateCourseName();
                kursId=kursController.promptForKursIndex();
                kursName=kursController.promptForKursName();
                kursController.changeCourseName(kursId,kursName);
                break;
            case 12:
                appView.showRemoveCourseFromStudent();
                studentId=studentController.promptForStudentIndex();
                kursId=kursController.promptForKursIndex();
                studentController.removeFromCourse(studentId,kursId);
                break;
            case 13:
                appView.showRemoveStudentFromCourse();
                kursId=kursController.promptForKursIndex();
                studentId=studentController.promptForStudentIndex();
                kursController.cancelStudent(kursId,studentId);
                break;
            case 14:
                appView.showRemoveAllCoursesFromStudent();
                studentId=studentController.promptForStudentIndex();
                studentController.removeFromAllCourses(studentId);
                break;
            case 15:
                appView.showRemoveAllStudentsFromCourse();
                kursId=kursController.promptForKursIndex();
                kursController.cancelAllStudents(kursId);
                break;
            case 16:
                appView.showRemoveStudent();
                studentId=studentController.promptForStudentIndex();
                studentController.removeStudent(studentId);
                break;
            case 17:
                appView.showRemoveCourse();
                kursId=kursController.promptForKursIndex();
                kursController.removeCourse(kursId);
                break;

            case 44:
                appView.showDbOption();
                kursController=kursControllerDB;
                studentController=studentControllerDB;
                break;
            case 55:
                appView.showXMLOption();
                kursController=kursControllerXML;
                studentController=studentControllerXML;
                break;
            default:
                helper=100;

        }// switch(helper)

        if(helper!=100) {
            appView.showNumberForFunctionalities();
            appView.showNumberForQuit();
        }
     }// while (helper!=100)

    appView.showByeMessage();

    if(scanner!=null)
        scanner.close();


 }   // public void Application()









}//public class AppController
