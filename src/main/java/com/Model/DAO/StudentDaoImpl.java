package com.Model.DAO;

import com.Model.DataSource;
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


    public List<Student> getAllStudents() {

        Connection con =null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Student> studList = new ArrayList<Student>();
        String query = "SELECT * FROM student";

        try {
            DataSource dataSource = new DataSource();
            con = dataSource.createConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

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
            try
            {
                if( con != null ) {
                    con.close();
                }
                if( stmt != null ) {
                    stmt.close();
                }
                if( rs != null ) {
                    rs.close();
                }
            }
            catch( Exception exe ) {
                exe.printStackTrace();
            }
        }

        return studList;
    }//public List<Student> getAllStudents()


    public void addStudent(Student student) {

            Connection dbConnection = null;
            Statement statement = null;
            String sql = "insert into student values(" + student.getStudentId() + "," + "'" + student.getStudentName() + "'"   + ")";

            try {
                DataSource dataSource = new DataSource();
                dbConnection = dataSource.createConnection();
                statement = dbConnection.prepareStatement(sql);
                statement.executeUpdate(sql);

                System.out.println("Record is inserted into student table for  Student : " + student.getStudentName());
            }
            catch( SQLException e ) {
                e.printStackTrace();
            }
            finally {
                try
                {
                    if( dbConnection != null ) {
                        dbConnection.close();
                    }
                    if( statement != null ) {
                        statement.close();
                    }
                }
                catch( Exception exe ) {
                    exe.printStackTrace();
                }
            }

    }// public void addStudent(Student student)



    public Student getStudent(int studentId) {

        DataSource dataSource = new DataSource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM student where studentid="+studentId;

        try{

            con = dataSource.createConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
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
            try {
                if( con != null ) {
                    con.close();
                }
                if( stmt != null ) {
                    stmt.close();
                }
                if( rs != null ) {
                    rs.close();
                }
            }
            catch( Exception exe ) {
                exe.printStackTrace();
            }
        }

        return null;
    }//public Student getStudent(int studentId)


    public void updateStudent(Student student) {

        Connection dbConnection = null;
        Statement statement = null;

        String sql = "update student set studentname=" + "'" + student.getStudentName() + "'" + "where studentid="
                + student.getStudentId();

        try {

            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.executeUpdate(sql);

            System.out.println("Record is updated into Student table for Student id : "
                    + student.getStudentId());

        }
        catch( SQLException e ) {
            e.printStackTrace();
        }
        finally {
                try
                {
                    if( dbConnection != null ) {
                        dbConnection.close();
                    }
                    if( statement != null ) {
                        statement.close();
                    }
                }
                catch( Exception exe ) {
                    exe.printStackTrace();
                }
            }
    }// public void updateStudent(Student student)





    public void deleteStudent(int studentId) {

        Connection dbConnection = null;
        Statement statement = null;

        String sql = "delete from student where studentid="+ studentId;

        try{
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.executeUpdate(sql);

            System.out.println("Record is deleted from Student table for Student id : "
                    + studentId);
        }
        catch( SQLException e ) {
            e.printStackTrace();
        }
        finally {
            try
            {
                if( dbConnection != null ) {
                    dbConnection.close();
                }
                if( statement != null ) {
                    statement.close();
                }
            }
            catch( Exception exe ) {
                exe.printStackTrace();
            }
        }

    }// public void deleteStudent(int studentId)





}

