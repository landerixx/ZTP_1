package com.Model.DAO;

import com.Model.ConnectionSingleton;
import com.Model.DbUtil;
import com.Model.Entity.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotrek on 2017-03-06.
 */
public class StudentDaoImpl implements StudentDao {

    private Connection connection;
    private Statement statement;
    private ResultSet rs = null;

    public List<Student> getAllStudents() {


        List<Student> studList = new ArrayList<Student>();
        String query = "SELECT * FROM student";

        try {
            connection = ConnectionSingleton.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){

                Student stud = new Student();
                stud.setStudentId(rs.getInt("studentid"));
                stud.setStudentName(rs.getString("studentname"));
                studList.add(stud);
            }
        }//try
        catch( SQLException e ) {
            e.printStackTrace();
        }
        finally {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }

        return studList;
    }//public List<Student> getAllStudents()


    public void addStudent(Student student) {


            String sql = "insert into student values(" + student.getStudentId() + "," + "'" + student.getStudentName() + "'"   + ")";

            try {
                connection = ConnectionSingleton.getConnection();
                statement = connection.prepareStatement(sql);
                statement.executeUpdate(sql);

                System.out.println("Record is inserted into student table for  Student : " + student.getStudentName());
            }
            catch( SQLException e ) {
                e.printStackTrace();
            }
            finally {
                DbUtil.close(statement);
                DbUtil.close(connection);
            }

    }// public void addStudent(Student student)



    public Student getStudent(int studentId) {


        String query = "SELECT * FROM student where studentid="+studentId;

        try{

            connection = ConnectionSingleton.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            while( rs.next() ) {

                Student stud = new Student();
                stud.setStudentId(rs.getInt("studentid"));
                stud.setStudentName(rs.getString("studentname"));
                return stud;
            }
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }

        finally
        {
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }

        return null;
    }//public Student getStudent(int studentId)


    public void updateStudent(Student student) {



        String sql = "update student set studentname=" + "'" + student.getStudentName() + "'" + "where studentid="
                + student.getStudentId();

        try {

            connection = ConnectionSingleton.getConnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);

            System.out.println("Record is updated into Student table for Student id : "
                    + student.getStudentId());

        }
        catch( SQLException e ) {
            e.printStackTrace();
        }
        finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
            }
    }// public void updateStudent(Student student)





    public void deleteStudent(int studentId) {



        String sql = "delete from student where studentid="+ studentId;

        try{
            connection = ConnectionSingleton.getConnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);

            System.out.println("Record is deleted from Student table for Student id : "
                    + studentId);
        }
        catch( SQLException e ) {
            e.printStackTrace();
        }
        finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }

    }// public void deleteStudent(int studentId)





}

