package com.Model.Entity;

/**
 * Created by Piotrek on 2017-03-06.
 */
public class Kurs {

    private int kursId;
    private String kursName;

    public Kurs(){};

    public Kurs(int kursId, String kursName) {
        this.kursId = kursId;
        this.kursName = kursName;
    }

    public int getKursId() {
        return kursId;
    }

    public void setKursId(int kursId) {
        this.kursId = kursId;
    }

    public String getKursName() {
        return kursName;
    }

    public void setKursName(String kursName) {
        this.kursName = kursName;
    }

    @Override
    public String toString() {
        return "Kurs{" +
                "kursId=" + kursId +
                ", kursName='" + kursName + '\'' +
                '}';
    }
}
