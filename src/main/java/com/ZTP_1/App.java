package com.ZTP_1;

import java.util.List;
import com.Model.DAO.*;
import com.Model.Entity.Kurs;
import com.Model.Entity.Student;
import com.Model.Entity.Zapisany;
import com.Service.StudentService;
import com.Service.StudentServiceImpl;

/*

http://www.codesenior.com/en/tutorial/Spring-Generic-DAO-and-Generic-Service-Implementation
A "service layer" exists between the UI and the backend
        systems that store data, and is in charge of managing the business rules of transforming and translating data between those two layers.
*/

/**
 * Hello world!
 *
 *
 * ZAPISANY -> 2 klucze glowne typu int? czy Student/Kurs
 *
 *ZAPISANY -> MOZNA DODAWAC KLUCZE, KTORE NIE ISTNIEJA W STUDENCI/KURS
 *
 *
 * UWAGA NA NULL POINTER EXCEPTION W SERVISACH PRZY ENCJACH JAKO PARAMETR
 * UWAGA NA NULL POINTER EXCEPTION W DAO'S PRZY OBIEKTACH
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

/*
        StudentDaoImpl stdao= new StudentDaoImpl();

        Student stud = new Student();
        stud.setStudentId(3);
        stud.setStudentName("Nowak");

       // stdao.addStudent(stud);


        List<Student> stList= stdao.getAllStudents();
        for(Student st: stList)
            System.out.println(st);

        Student zBazy = stdao.getStudent(3);
        System.out.println(zBazy);

        zBazy.setStudentName("POPRAWIONE");
        //stdao.updateStudent(zBazy);

        Student zBazy2= stdao.getStudent(3);
        System.out.println(zBazy2);

        System.out.println("USUWAMY");
        //stdao.deleteStudent(3);


        List<Student> stList2= stdao.getAllStudents();
        for(Student st: stList2)
            System.out.println(st);

*/
        ////////////
        //KURSY
        //

/*
    KursDaoImpl kursdao = new KursDaoImpl();

        Kurs kurs = new Kurs();
        kurs.setKursId(2);
        kurs.setKursName("JAVA");

        //kursdao.addKurs(kurs);




        kurs.setKursName("PROGRAMOWANIE");
        kursdao.updateKurs(kurs);

        Kurs kurs2 = kursdao.getKurs(1);
        System.out.println(kurs2);

        //kursdao.deleteKurs(1);
        List<Kurs> kursy = kursdao.getAllCourses();
        for(Kurs k: kursy)
            System.out.println(k);

*/

            //ZAPISANY
/*
        Zapisany zapisany = new Zapisany();
        zapisany.setKursId(1);
        zapisany.setStudentId(4);

        ZapisanyDaoImpl zapDao = new ZapisanyDaoImpl();
        //zapDao.addZapisany(zapisany);






        //zapDao.deleteZapisany(1,4);

        List<Zapisany> zapisanyList = zapDao.getAllZapisany();
        for(Zapisany zap: zapisanyList)
            System.out.println(zap);

        Zapisany zap2 = zapDao.getZapisany(2,3);
        System.out.println(zap2);
*/


//SERVICY

        //STUDENT
        StudentDaoImpl stdao= new StudentDaoImpl();
        StudentService stService = new StudentServiceImpl(stdao);

        List<Student> listastud= stService.getAll();

        for(Student st: listastud)
            System.out.println(st);

        Student s= stService.get(3);
        Student s2 = stService.get(4); // nie ma studenta o podanym ID -> wychodzi NULL
        System.out.println(s);

        stService.add(s); // w bazie jest juz taki student
        Student nowy = new Student(8, "Nowy");
        //stService.add(nowy); // juz


        nowy.setStudentName("NowyUpdate");
        //stService.update(nowy); //zupdatowany

        Student s3 = new Student (100,"Nie w Bazie");
        stService.update(s3); // nie istnieje student w bazie o takim ID

        List<Integer> indeksy = stService.getAllIndexes();
        System.out.println(indeksy);


        //stService.remove(nowy);
          stService.remove(s3); // nie istnieje student w bazie o takim ID
         listastud= stService.getAll();

        for(Student st: listastud)
            System.out.println(st);








    }

}
