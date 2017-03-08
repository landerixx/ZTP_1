package com.Controller;

import com.Model.Entity.Student;
import com.Service.StudentService;
import com.View.StudentView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Piotrek on 2017-03-07.
 */
public class StudentControllerImpl implements StudentController {


    private StudentService studentService;
    private StudentView studentView;

    public StudentControllerImpl(){};
    public StudentControllerImpl(StudentService studentService, StudentView studentView){

        this.studentService=studentService;
        this.studentView=studentView;
    }




    public boolean createStudent(int studentId, String name){

        boolean result;
        result = studentService.add(new Student(studentId,name));

        if(result)
           studentView.addedStudent(studentId,name);

        return result;
    }//public boolean createStudent(int studentId, String name)


    public void displayAllStudents(){

        List<Student> studentList=studentService.getAll();
        HashMap<Integer,String> map= new HashMap<Integer, String>();
        for(Student stud: studentList)
            map.put(stud.getStudentId(),stud.getStudentName());

        studentView.showAllCourses(map);

    }//  public void displayAllStudents()



    public boolean displayStudent(int studentId) {

        boolean result=false;

        Student student = studentService.get(studentId);
        if(student!=null){
            result=true;
            studentView.showStudent(studentId,student.getStudentName());

        }

        return result;
    }

    public boolean changeStudentName(int studentId, String newName) {

        boolean result;
        result = studentService.update(new Student(studentId,newName));

        if(result)
            studentView.showUpdatedStudent(studentId,newName);

        return result;

    }

}
