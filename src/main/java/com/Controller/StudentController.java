package com.Controller;

import com.Service.StudentService;
import com.View.StudentView;

/**
 * Created by Piotrek on 2017-03-07.
 */
public class StudentController {


    private StudentService studentService;
    private StudentView studentView;

    public StudentController(){};
    public StudentController(StudentService studentService, StudentView studentView){

        this.studentService=studentService;
        this.studentView=studentView;
    }

}
