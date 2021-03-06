package com.Model.Entity;

/**
 * Created by Piotrek on 2017-03-06.
 */
public class Zapisany {

    private int kursId;
    private int studentId;

    public Zapisany() {
    }

    public Zapisany(int kursId, int studentId) {
        this.kursId = kursId;
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getKursId() {
        return kursId;
    }

    public void setKursId(int kursId) {
        this.kursId = kursId;
    }

    @Override
    public String toString() {
        return "Zapisany{" +
                "kursId=" + kursId +
                ", studentId=" + studentId +
                '}';
    }
}
