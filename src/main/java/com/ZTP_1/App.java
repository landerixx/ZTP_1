package com.ZTP_1;

import com.Model.DataSource;
import com.Model.Entity.Kurs;
import com.Model.Entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.Model.DAO.*;
import com.Model.Entity.Zapisany;

/**
 * Hello world!
 *
 *
 * ZAPISANY -> 2 klucze glowne typu int? czy Student/Kurs
 *
 *ZAPISANY -> MOZNA DODAWAC KLUCZE, KTORE NIE ISTNIEJA W STUDENCI/KURS
 *
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

        stdao.addStudent(stud);


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

        kursdao.deleteKurs(1);
        List<Kurs> kursy = kursdao.getAllCourses();
        for(Kurs k: kursy)
            System.out.println(k);

        */

            //ZAPISANY

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



    }

}
