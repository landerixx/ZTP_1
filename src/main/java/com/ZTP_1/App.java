package com.ZTP_1;

import java.util.Scanner;

import com.Controller.*;
import com.Model.DAO.*;
import com.Service.*;
import com.View.KursView;
import com.View.StudentView;
import com.View.ZapisanyView;

/*

http://www.codesenior.com/en/tutorial/Spring-Generic-DAO-and-Generic-Service-Implementation
A "service layer" exists between the UI and the backend
        systems that store data, and is in charge of managing the business rules of transforming and translating data between those two layers.

        https://www.tutorialspoint.com/design_pattern/mvc_pattern.htm

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
 * UWAGA NA NULL POINTER EXCEPTION W SERVISACH PRZY ENCJACH JAKO PARAMETR +
 * UWAGA NA NULL POINTER EXCEPTION W DAO'S PRZY OBIEKTACH -> zabezpieczone w serwisach
 *
 *
 * ZMIENIC VOID NA BOOL W SERWISACH, BEDZIE LATWIEJ W KOTROLERACH
 *
 *
 * 1.CREATE
 *   +   1.WPROWADZ STUDENTA
 *   +   2.WPROWADZ KURS
 *
 *      3.ZAPIS STUDENTA NA KURS
 *
 *      9.WYJSCIE DO MENU GL.
 *
 * 2.READ
 *
 *    + 1. WYSWIETL LISTE WSZYSTKICH STUDENTOW
 *    +  2. WYSWIETL LISTE WSZYSTKICH KURSOW
 *
 *     +   3. WYSWIETL KURS
 *     +   4. WYSWIETL STUDENTA
 *
 *      5. POKAZ STUDENTA wraz z jego kursami
 *      6. POKAZ KURS wraz z jego studentami
 *
 *      9.WYJSCIE DO MENU GL.
 *
 * 3.UPDATE
 *
 *   +   1. EDYTUJ NAZWISKO STUDENTA
 *   +   2. EDYTUJ NAZWE KURSU
 *
 *      9.WYJSCIE DO MENU GL.
 *
 * 4.DELETE -> USUWAJAC KURS LUB STUDENTA MUSZE NAJPIERW WYPISAC GO Z KURSOW WYPISAC LISTE STUDENTOW -> gdzie to zaimplementowac
 *
 *      1. USUN STUDENTA
 *      2. USUN KURS
 *
 *      3. WYPISZ STUDENTA Z KURSU (STUDENT)
 *      4. ANULUJ STUDENTOWI KURS (KURS)
 *
 *      WAZNE 5. USUN WSZYSTKICH Z KURSU
 *      WAZNE 6. USUN WZYSTKIE KURSY STUDENTA
 *
 *      9. WYJSCIE DO MENU GLOWNEGO
 *
 * 9.WYJSCIE Z PROGRAMU
 *
 *
 * MOZLIWA TEZ OPCJA:
 * JESTEM W KURSIE:
 *      POKAZ JEGO DANE
 *      POKAZ STUDENTOW
 *      EDYTUJ KURS
 *      USUN KURS (WYPISZ STUDENTOW Z KURSU A POTEM DOPIERO USUN KURS)
 *
 * JESTEM W STUDENCIE:
 *      POKAZ JEGO DANE
 *      POKAZ KURSY
 *      EDYTUJ STUDENTA
 *      USUN STUDENTA (ANULUJ KURSY A POTEM DOPIERO USUN STUDENTA)
 *
 *
 *
 */

public class App 
{
    public static void main( String[] args ) {
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

        /*
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

*/
        //PRZETESTUJ SERVICES
        //KURSY
        //ZAPISANY

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
        ZapisanyView zapisanyView = new ZapisanyView();

      //Controllers
        KursController kursController = new KursControllerImpl(kursService,kursView);
        StudentController studentController = new StudentControllerImpl(studentService,studentView);
        ZapisanyController zapisanyController = new ZapisanyController(zapisanyService,zapisanyView);


        Scanner scanner = new Scanner(System.in);


/*
                                    //KURSY

        int kursIndex;
        String kursName;

        //UTWORZ KURS
        System.out.println("Tworzysz kurs. Podaj indeks");
         kursIndex = scanner.nextInt();
        System.out.println("Podaj nazwe kursu");
         kursName = scanner.next();
        kursController.createKurs(kursIndex,kursName);




        //WYSWIETL WSZYSTKIE KURSY
        kursController.displayCourses();


        //EDYTUJ NAZWE KURSU
        System.out.println("Podaj nr indeksu kursu, ktoremu chcesz zmienic nazwe.");
        kursIndex = scanner.nextInt();
        System.out.println("Podaj nowa nazwe");
         kursName = scanner.next();
        kursController.changeCourseName(kursIndex,kursName);


       //WYSWIETL KURS
        System.out.println("Podaj nr indedksu kursu, ktorego chcesz wyswietlic");
        kursIndex=scanner.nextInt();
        kursController.displayCourse(kursIndex);

*/


                                     //STUDENCI


        int studentIndex;
        String studentName;

        /*
        //UTWORZ STUDENTA

        System.out.println("Tworzysz studenta. Podaj indeks");
        studentIndex = scanner.nextInt();
        System.out.println("Podaj nazwe studenta");
        studentName = scanner.next();
        studentController.createStudent(studentIndex,studentName);


        //WYSWIETL WSZYSTKICH STUDENTOW
        studentController.displayAllStudents();

        //EDYTUJ NAZWE Studenta

        System.out.println("Podaj nr indeksu studenta, ktoremu chcesz zmienic nazwe.");
        studentIndex = scanner.nextInt();
        System.out.println("Podaj nowa nazwe");
        studentName = scanner.next();
        studentController.changeStudentName(studentIndex,studentName);

        */

        studentController.displayAllStudents();

        //WYSWIETL STUDENTA
        System.out.println("Podaj nr indeksu studenta, ktorego chcesz wyswietlic");
        studentIndex=scanner.nextInt();
        studentController.displayStudent(studentIndex);



        scanner.close();

    }// public void application()

}
