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
public class StudentControllerImpl implements StudentController {


    private StudentService studentService;
    private StudentView studentView;

    private ZapisanyService zapisanyService;
    private KursService kursService;
    private KursView kursView;

    private Scanner scanner;

    public StudentControllerImpl(){};
    public StudentControllerImpl(StudentService studentService, StudentView studentView){

        this.studentService=studentService;
        this.studentView=studentView;
    }

    public StudentControllerImpl(StudentService studentService, StudentView studentView, ZapisanyService zapisanyService,
                                 KursService kursService, KursView kursView){

        this.studentService=studentService;
        this.studentView=studentView;
        this.zapisanyService=zapisanyService;
        this.kursService=kursService;
        this.kursView=kursView;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setZapisanyService(ZapisanyService zapisanyService) {
        this.zapisanyService = zapisanyService;
    }

    public void setKursService(KursService kursService) {
        this.kursService = kursService;
    }

    public int promptForStudentIndex(){

        scanner= new Scanner(System.in);
        int studentIndex;
        studentView.showPromptMessageForStudentIndex();
        studentIndex=scanner.nextInt();
      //  scanner.close();
        return studentIndex;

    }

    public String promptForStudentName(){

        scanner= new Scanner(System.in);
        String studentName;
        studentView.showPromptMessageForStudentName();

        studentName = scanner.next();
       // scanner.close();
        return studentName;
    }










    public boolean createStudent(int studentId, String name){

        boolean result;
        result = studentService.add(new Student(studentId,name));

        if(result)
           studentView.addedStudent(studentId,name);

        return result;
    }//public boolean createStudent(int studentId, String name)


    public void displayAllStudents(){

        List<Student> studentList=studentService.getAll();
        HashMap<Integer,String> map= new HashMap<Integer, String>();
        for(Student stud: studentList)
            map.put(stud.getStudentId(),stud.getStudentName());

        studentView.showAllCourses(map);

    }//  public void displayAllStudents()



    public boolean displayStudent(int studentId) {

        boolean result=false;

        Student student = studentService.get(studentId);
        if(student!=null){
            result=true;
            studentView.showStudent(studentId,student.getStudentName());

        }

        return result;
    }// public boolean displayStudent(int studentId)

    public boolean changeStudentName(int studentId, String newName) {

        boolean result;
        result = studentService.update(new Student(studentId,newName));

        if(result)
            studentView.showUpdatedStudent(studentId,newName);

        return result;

    }//  public boolean changeStudentName(int studentId, String newName)



    //===================================================

    public boolean displayStudentWithCourses(int studentId) {

        boolean result=displayStudent(studentId); //jezeli false nie ma takiego studenta

        studentView.showStudentWithCourses();

        Set<Integer> coursesIds= zapisanyService.getIds(studentId,true); //true -> wyciagniemy wszystkich kursy tego studenta
        Kurs kurs;

        for(Integer id: coursesIds) {

            kurs = kursService.get(id);
            kursView.showCourse(id,kurs.getKursName());
        }
        if(coursesIds.isEmpty())
            studentView.showMessageNoCourses();

        return result;
    } //  public boolean displayStudentWithCourses(int studentId)






    public boolean enrollStudentforCourse(int studentId, int kursId) {


        Student stud = studentService.get(studentId);
        Kurs kurs = kursService.get(kursId);

        boolean isStudent = stud !=null;
        boolean isKurs = kurs!=null;
        boolean result = isStudent && isKurs;

        if(result) {
           boolean isEnrolled= zapisanyService.add(new Zapisany(kursId, studentId));
           if(isEnrolled)
            studentView.showEnroll(studentId,stud.getStudentName(),kursId,kurs.getKursName());
        }


        return result;
    } // public boolean enrollStudentforCourse(int studentId, int kursId)



    //===================================================


    public boolean removeFromCourse(int studentId, int kursId) {

        boolean result=false;

        Student stud = studentService.get(studentId);
        Kurs kurs = kursService.get(kursId);


        result=zapisanyService.remove(new Zapisany(kursId,studentId));

        if(result)
            studentView.showRemoveFromCourseMessage(studentId, stud.getStudentName(),kursId, kurs.getKursName());


        return result;
    }// public boolean removeFromCourse(int studentId, int kursId)



    public boolean removeFromAllCourses(int studentId) {

        boolean result =false;

        Student stud = studentService.get(studentId);
        boolean isStudent = stud !=null;

        Set<Integer> coursesIds;
        if(isStudent) {
            coursesIds = zapisanyService.getIds(studentId, true); //true -> wyciagniemy wszystkie kursy tego studenta
            for(Integer kursId: coursesIds)
                zapisanyService.remove(new Zapisany(kursId,studentId));

            result = true;
            studentView.removeFromAllCoursesMessage(studentId,stud.getStudentName());
        }

        return result;
    }// public boolean removeFromAllCourses(int studentId)



    public boolean removeStudent(int studentId) {

        boolean result=false;

        Student stud = studentService.get(studentId);
        boolean isStudent = stud !=null;
        Set<Integer> coursesIds;
        if(isStudent){

            coursesIds = zapisanyService.getIds(studentId, true); //true -> wyciagniemy wszystkie kursy tego studenta

            //jaka strategia -> usuwamy zapisy na kursy, czy powiadamiamy uzytkownika, ze jest zapisany na kurs
            //narazie tylko powiadamiam


            if(coursesIds.isEmpty()) {
                studentService.remove(stud);
                studentView.removeStudentPositiveMessage(studentId, stud.getStudentName());
                result=true;

            }
            else
                studentView.removeStudentNegativeMessage(studentId, stud.getStudentName());
        }


        return result;
    }// public boolean removeStudent(int studentId)


}
