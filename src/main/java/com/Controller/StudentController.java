package com.Controller;

/**
 * Created by Piotrek on 2017-03-08.
 */
public interface StudentController {

    public boolean createStudent(int studentId, String name);
    public void displayAllStudents();
    public boolean displayStudent(int studentId);
    public boolean changeStudentName(int studentId, String newName);
    public boolean displayStudentWithCourses(int studentId);
    public boolean enrollStudentforCourse(int studentId, int kursId);

    public boolean removeFromCourse(int studentId, int kursId);
    public boolean removeFromAllCourses(int studentId);
    public boolean removeStudent(int studentId);

}
