package com.ZTP_1;

import com.Model.DataSource;
import com.Model.Entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.Model.DAO.*;

/**
 * Hello world!
 *
 *
 * ZAPISANY -> 2 klucze glowne typu int? czy Student/Kurs
 *
 *
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        StudentDaoImpl stdao= new StudentDaoImpl();

        Student stud = new Student();
        stud.setStudentId(3);
        stud.setStudentName("Nowak");

        //stdao.addStudent(stud);


        List<Student> stList= stdao.getAllStudents();
        for(Student st: stList)
            System.out.println(st);

        Student zBazy = stdao.getStudent(3);
        System.out.println(zBazy);

        zBazy.setStudentName("POPRAWIONE");
        stdao.updateStudent(zBazy);

        Student zBazy2= stdao.getStudent(3);
        System.out.println(zBazy2);

        System.out.println("USUWAMY");
       // stdao.deleteStudent(1);


        List<Student> stList2= stdao.getAllStudents();
        for(Student st: stList2)
            System.out.println(st);









    }

}
