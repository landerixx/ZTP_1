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
 *
 *
 *
 *
 * 3 drogi:
 * ALBO
 *  STWORZYC DELETE W ZAPISYCONTROLLER ORAZ wyswietlanie studenta i jego kursow/ kursu i jego studentow
 *
 * ALBO
 *  DODAC do KursController: ZapisanyService oraz StudentController
 *  TWORZYC DEDLETE I METODY W ODOPOWIEDNICH KONTROLERACH
 *
 * ALBO
 *  DODAC DO KursController: ZapisanyService, StudentService i StudentView -> wybieram to
 *
 *
 *
 *
 * W KONTROLERACH SCANNER!!!!!!!!!!!!!
 *
 *
 * 1.CREATE +
 *   +   1.WPROWADZ STUDENTA
 *   +   2.WPROWADZ KURS
 *
 *    + 3.ZAPIS STUDENTA NA KURS
 *
 *
 *      9.WYJSCIE DO MENU GL.
 *
 * 2.READ +
 *
 *    + 1. WYSWIETL LISTE WSZYSTKICH STUDENTOW
 *    +  2. WYSWIETL LISTE WSZYSTKICH KURSOW
 *
 *     +   3. WYSWIETL KURS
 *     +   4. WYSWIETL STUDENTA
 *
 *     + 5. POKAZ STUDENTA wraz z jego kursami
 *     + 6. POKAZ KURS wraz z jego studentami
 *
 *      9.WYJSCIE DO MENU GL.
 *
 * 3.UPDATE +
 *
 *   +   1. EDYTUJ NAZWISKO STUDENTA
 *   +   2. EDYTUJ NAZWE KURSU
 *
 *      9.WYJSCIE DO MENU GL.
 *
 * 4.DELETE  +                    -> USUWAJAC KURS LUB STUDENTA MUSZE NAJPIERW WYPISAC GO Z KURSOW WYPISAC LISTE STUDENTOW
 *
 *      1. USUN STUDENTA +
 *      2. USUN KURS +
 *
 *  +   3. WYPISZ STUDENTA Z KURSU (STUDENT) +
 *      4. ANULUJ STUDENTOWI KURS (KURS) +
 *
 *      WAZNE 5. USUN WSZYSTKICH Z KURSU +
 *      WAZNE 6. USUN WZYSTKIE KURSY STUDENTA +
 *
 *      9. WYJSCIE DO MENU GLOWNEGO
 *
 * 9.WYJSCIE Z PROGRAMU
 *
 *
 *
 *
 * MOZLIWA TEZ OPCJA:
 * JESTEM W KURSIE:
 *      POKAZ JEGO DANE
 *      POKAZ STUDENTOW
 *      EDYTUJ KURS
 *      USUN STUDENTA Z KURSU
 *      USUN KURS (WYPISZ STUDENTOW Z KURSU A POTEM DOPIERO USUN KURS)
 *
 * JESTEM W STUDENCIE:
 *      POKAZ JEGO DANE
 *      POKAZ KURSY
 *      EDYTUJ STUDENTA
 *      USUN KURS STUDENTOWI
 *      USUN STUDENTA (ANULUJ KURSY A POTEM DOPIERO USUN STUDENTA)
 *
 *
 *
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
