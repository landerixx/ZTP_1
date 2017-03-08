package com.Controller;

/**
 * Created by Piotrek on 2017-03-08.
 */
public interface KursController {

    public boolean createKurs(int kursId, String name);
    public void displayCourses();
    public boolean displayCourse(int kursId);
    public boolean changeCourseName(int kursId, String newName);
    public boolean displayCourseWithStudents(int kursId);

    public boolean cancelStudent(int kursId, int StudentId);
    public boolean cancelAllStudents(int kursId);
    public boolean removeCourse(int kursId);

}
