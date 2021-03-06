package com.ZTP_1;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}


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
//
//KURSY
//ZAPISANY






























/*
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
        kursController.showCourse(kursIndex);

*/


//STUDENCI




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



        studentController.displayAllStudents();

        //WYSWIETL STUDENTA
        System.out.println("Podaj nr indeksu studenta, ktorego chcesz wyswietlic");
        studentIndex=scanner.nextInt();
        studentController.displayStudent(studentIndex);

        */



//==============================


//SPRAWDZAM zapisanyDAO delete ALL STUDENTS/COURSES
//DAM TRUE USUNIETE WSZYSTKIE KURSY STUDENTA
//DAM FALSE USUNIETE WSZYSSCY STUDENCI KURSU

//  zapisanyDao.deleteAllZapisany(3,true);
//zapisanyService.deleteAllZapisanyStudentsFromKurs(3);
// zapisanyService.deleteAllZapisanyCoursesFromStudent(5);




//KOLEJNY ETAP



        /*
        //WYSWIETL KURS WRAZ Z JEGO STUDENTAMI

        System.out.println("Podaj nr indeksu kursu, ktorego chcesz wyswietlic razem z zapisanymi studentami");
        kursIndex=scanner.nextInt();

        kursController.displayCourseWithStudents(kursIndex);
        */



        /*
        //WYSWIETL STUDENTA Z JEGO KURSAMI

        System.out.println("Podaj nr indeksu studenta, ktorego chcesz wyswietlic z jego kursami");
        studentIndex=scanner.nextInt();

        studentController.displayStudentWithCourses(studentIndex);
        */

//ZAPIS STUDENTA KA KURS

        /*
        System.out.println("Podaj nr studenta, jakiego chcesz zapisac na kurs");
        studentIndex=scanner.nextInt();
        System.out.println("Podaj nr kursu");
        kursIndex=scanner.nextInt();
        studentController.enrollStudentforCourse(studentIndex,kursIndex);
        */


//USUWAMY Kurs STUDENTA

        /*
        System.out.println("Podaj nr studenta, jakiego chcesz wypisac z kursu");
        studentIndex=scanner.nextInt();
        System.out.println("Podaj nr kursu z jakiego chcesz go wypisac");
        kursIndex=scanner.nextInt();
        studentController.removeFromCourse(studentIndex,kursIndex);

        */

//USUWAMY studenta z kursu

/*
        System.out.println("Podaj id kursu z ktorego chcesz wypisac studenta");
        kursIndex=scanner.nextInt();
        System.out.println("Podaj id studenta");
        studentIndex=scanner.nextInt();
        kursController.cancelStudent(kursIndex,studentIndex);
*/

//USUWAMY WSZYSTKIE KURSY STUDENTA

        /*
        System.out.println("Podaj nr studenta, jakiego chcesz wypisac z wszystkich kursow");
        studentIndex=scanner.nextInt();
        //studentController.removeFromAllCourses(studentIndex);
        */

        /*
    //USUWAMY WSZYSTKICH STUDENTOW Z KURSU
        System.out.println("Podaj id kursu z ktorego chcesz wypisac wszystkich studentow");
        kursIndex=scanner.nextInt();
        kursController.cancelAllStudents(kursIndex);
        */


        /*
      //USUWAMY STUDENTA Z BAZY!!

        System.out.println("Podaj nr studenta, jakiego chcesz usunac z bazy");
        studentIndex=scanner.nextInt();
        studentController.removeStudent(studentIndex);
        */

//USUWAMY KURS Z BAZY!!
/*
        System.out.println("Podaj id kursu z ktorego chcesz wypisac studenta");
        kursIndex=scanner.nextInt();
        kursController.removeCourse(kursIndex);

        scanner.close();
*/


//TESTY XML
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


        /*
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

        */