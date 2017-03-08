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


    public boolean add(Student entity) {

        boolean result=false;

        if(entity!=null && !getAllIndexes().contains(entity.getStudentId())) {
            studentDao.addStudent(entity);
            result=true;
        }
        else
            System.err.println("Błąd. Nie można wprowadzić tego studenta do bazy.");

        return result;
    }



    public boolean update(Student entity) {

        boolean result=false;

        if(entity!=null && getAllIndexes().contains(entity.getStudentId())) {
            studentDao.updateStudent(entity);
            result =true;
        }
        else
            System.err.println("Błąd. W BAZIE NIE ISTNIEJE STUDENT O TAKIM ID");

        return result;
    }

    public boolean remove(Student entity) {

        boolean result=false;
        if(entity!=null && getAllIndexes().contains(entity.getStudentId())) {
            studentDao.deleteStudent(entity.getStudentId());
            result =true;
        }
        else
            System.err.println("Błąd. Nie istnieje  student w bazie z takim ID");

        return result;
    }





    public List<Integer> getAllIndexes() {

        List<Student> students = this.getAll();
        List<Integer> studentsIdList = new ArrayList<Integer>();
        for(Student stud: students)
            studentsIdList.add(stud.getStudentId());

        return studentsIdList;
    }


}
