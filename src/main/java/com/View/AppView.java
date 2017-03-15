package com.View;

/**
 * Created by Piotrek on 2017-03-09.
 */
public class AppView {


    public void showHello() {

        System.out.println("=======================");
        System.out.println("Witaj w mojej aplikacji");
        System.out.println("=======================");

    }


    public void showAllFunctionalities() {

        showNumberForFunctionalities();
        showCreateStudent();
        showCreateCourse();
        showEnrollStudentForCourse();
        showAllStudents();
        showAllCourses();
        showStudent();
        showCourse();
        showStudentWithCourses();
        showCourseWithStudents();
        showUpdateStudentsName();
        showUpdateCourseName();
        showRemoveCourseFromStudent();
        showRemoveStudentFromCourse();
        showRemoveAllCoursesFromStudent();
        showRemoveAllStudentsFromCourse();
        showRemoveStudent();
        showRemoveCourse();
        showNumberForQuit();
        showDbOption();
        showXMLOption();
        System.out.println();

    }


    public void showNumberForFunctionalities() {

        System.out.println();
        System.out.println("Aby zobaczyc liste funkjonalnosci wprowadz 0");
    }

    public void showNumberForQuit() {
        System.out.println("aby wyjsc w programu wpisz 100");
    }


    public void showCreateStudent() {

        System.out.println("1. UTWORZ STUDENTA");
    }

    public void showCreateCourse() {

        System.out.println("2. UTWORZ KURS");
    }

    public void showEnrollStudentForCourse() {
        System.out.println("3. ZAPIS STUDENTA NA KURS");
    }


    public void showAllStudents() {

        System.out.println("4. WYSWIETL WSZYSTKICH STUDENTOW");
    }

    public void showAllCourses() {

        System.out.println("5. WYSWIETL WSZYSTKIE KURSY");
    }

    public void showStudent() {
        System.out.println("6. WYSWIETL STUDENTA");
    }


    public void showCourse() {
        System.out.println("7. WYSWIETL KURS");
    }

    public void showStudentWithCourses() {

        System.out.println("8. WYSWIETL STUDENTA Z JEGO KURSAMI");
    }

    public void showCourseWithStudents() {
        System.out.println("9. WYSWIETL KURS WRAZ Z JEGO STUDENTAMI");
    }


    public void showUpdateStudentsName() {
        System.out.println("10. EDYTUJ NAZWE STUDENTA");
    }


    public void showUpdateCourseName() {
        System.out.println("11. EDYTUJ NAZWE KURSU");
    }


    public void showRemoveCourseFromStudent() {

        System.out.println("12. USUWAMY Kurs STUDENTA");
    }

    public void showRemoveStudentFromCourse() {

        System.out.println("13. USUWAMY studenta z kursu");
    }


    public void showRemoveAllCoursesFromStudent() {

        System.out.println("14. USUWAMY WSZYSTKIE KURSY STUDENTA");
    }

    public void showRemoveAllStudentsFromCourse() {
        System.out.println("15. USUWAMY WSZYSTKICH STUDENTOW Z KURSU");
    }

    public void showRemoveStudent() {

        System.out.println("16. USUWAMY STUDENTA Z BAZY!!");
    }

    public void showRemoveCourse() {

        System.out.println("17. USUWAMY KURS Z BAZY!!");
    }


    public void showByeMessage() {
        System.out.println("DZiekujemy za skorzystanie z aplikacji.");
    }


    public void showDbOption() {
        System.out.println("44. ZMIENIAM NA DB");
    }

    public void showXMLOption() {
        System.out.println("55. ZMIENIAM NA XML");
    }
}