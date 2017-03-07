package com.Service;

import com.Model.DAO.StudentDao;
import com.Model.Entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotrek on 2017-03-07.
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao){
        this.studentDao=studentDao;
    }





    public List<Student> getAll() {

        return studentDao.getAllStudents();
    }


    public Student get(int studentId) {

        if(getAllIndexes().contains(studentId))
            return studentDao.getStudent(studentId);
        else
            System.err.println("Błąd. NIE MA STUDENTA O PODANYM ID: " + studentId);
         return null;


    }


    public void add(Student entity) {

        if(entity!=null && !getAllIndexes().contains(entity.getStudentId()))
            studentDao.addStudent(entity);
        else
            System.err.println("Błąd. Nie można wprowadzić tego studenta do bazy.");
    }



    public void update(Student entity) {

        if(entity!=null && getAllIndexes().contains(entity.getStudentId()))
            studentDao.updateStudent(entity);
        else
            System.err.println("Błąd. W BAZIE NIE ISTNIEJE STUDENT O TAKIM ID");
    }

    public void remove(Student entity) {

        if(entity!=null && getAllIndexes().contains(entity.getStudentId()))
            studentDao.deleteStudent(entity.getStudentId());
        else
            System.err.println("Błąd. Nie istnieje  student w bazie z takim ID");
    }





    public List<Integer> getAllIndexes() {

        List<Student> students = this.getAll();
        List<Integer> studentsIdList = new ArrayList<Integer>();
        for(Student stud: students)
            studentsIdList.add(stud.getStudentId());

        return studentsIdList;
    }


}
