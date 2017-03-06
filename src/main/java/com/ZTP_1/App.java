package com.ZTP_1;

import com.Model.DataSource;
import com.Model.Entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        DataSource dataSource = new DataSource();
        Connection con = dataSource.createConnection();
        Statement stmt = null;
        ResultSet rs = null;
        List<Student> employeeList = new ArrayList<Student>();


        try
        {
            String query = "SELECT * FROM student";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while( rs.next() )
            {
                Student employee = new Student();
                employee.setStudentId(rs.getInt("studentid"));
                employee.setStudentName(rs.getString("studentname"));
                employeeList.add(employee);
            }
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }

        finally
        {
            try
            {
                if( con != null )
                {
                    con.close();
                }
                if( stmt != null )
                {
                    stmt.close();
                }
                if( rs != null )
                {
                    rs.close();
                }
            }
            catch( Exception exe )
            {
                exe.printStackTrace();
            }

        }
        for(Student st: employeeList ){
            System.out.println(st);
        }











    }

}
