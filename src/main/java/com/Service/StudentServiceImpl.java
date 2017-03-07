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
            System.out.println("NIE MA STUDENTA O PODANYM ID");
         return null;


    }


    public void add(Student entity) {

        if(!getAllIndexes().contains(entity.getStudentId()))
            studentDao.addStudent(entity);
        else
            System.out.println("W bazie jest juz student z takim ID, nie mozna dodac");
    }


    //MOZE NIE ISTNIEJ STUDENT W BAZIE
    public void update(Student entity) {

        if(getAllIndexes().contains(entity.getStudentId()))
            studentDao.updateStudent(entity);
        else
            System.out.println("W BAZIE NIE ISTNIEJE STUDENT O TAKIM ID");
    }

    public void remove(Student entity) {

        if(getAllIndexes().contains(entity.getStudentId()))
            studentDao.deleteStudent(entity.getStudentId());
        else
            System.out.println("Nie istnieje  student w bazie z takim ID");
    }





    public List<Integer> getAllIndexes() {

        List<Student> students = this.getAll();
        List<Integer> studentsIdList = new ArrayList<Integer>();
        for(Student stud: students)
            studentsIdList.add(stud.getStudentId());

        return studentsIdList;
    }


}
