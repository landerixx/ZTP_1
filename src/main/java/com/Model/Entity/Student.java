package com.Model.Entity;

/**
 * Created by Piotrek on 2017-03-06.
 */
public class Student {

    private int studentId;
    private String studentName;

    public Student(){};
    public Student(int studentId, String studentName){

        this.studentId=studentId;
        this.studentName=studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
