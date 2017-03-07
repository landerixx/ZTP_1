package com.Model.DAO;

import com.Model.DataSource;
import com.Model.Entity.Student;
import com.Model.Entity.Zapisany;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotrek on 2017-03-06.
 */
public class ZapisanyDaoImpl implements ZapisanyDao {

    public List<Zapisany> getAllZapisany() {

        Connection con =null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Zapisany> zapisanyList = new ArrayList<Zapisany>();
        String query = "SELECT * FROM zapisany";

        try {
            DataSource dataSource = new DataSource();
            con = dataSource.createConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while(rs.next()){

                Zapisany zapisany = new Zapisany();
                zapisany.setStudentId(rs.getInt("studentid"));
                zapisany.setKursId(rs.getInt("kursid"));
                zapisanyList.add(zapisany);
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

        return zapisanyList;

    }// public List<Zapisany> getAllZapisany()



    public void addZapisany(Zapisany zapisany) {

        Connection dbConnection = null;
        Statement statement = null;
        String sql = "insert into zapisany values(" + zapisany.getKursId() + "," + "'" + zapisany.getStudentId() + "'"   + ")";

        try {
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.executeUpdate(sql);

            System.out.println("Record is inserted into zapisany table for  Zapisany : (" + zapisany.getKursId() + "," + zapisany.getStudentId() +")");
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

    }// public void addZapisany(Zapisany zapisany)


    public Zapisany getZapisany(int kursId, int studentId) {

        DataSource dataSource = new DataSource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM zapisany where kursid="+kursId +" AND studentid="+studentId;

        try{

            con = dataSource.createConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while( rs.next() ) {

                Zapisany zapisany = new Zapisany();
                zapisany.setStudentId(rs.getInt("studentid"));
                zapisany.setKursId(rs.getInt("kursid"));
                return zapisany;
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

    }// public Zapisany getZapisany(int kursId, int studentId)

    public void updateZapisany(Zapisany zapisany) {

    }



    public void deleteZapisany(int kursId, int studentId) {


        Connection dbConnection = null;
        Statement statement = null;

        String sql = "delete from zapisany where kursid="+kursId +" AND studentid="+ studentId;

        try{
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.executeUpdate(sql);

            System.out.println("Record is deleted from ZAPISANY table for (kursId,StudentId): ("
                    +kursId +"," +studentId+")");
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

    }//public void deleteZapisany(int kursId, int studentId)
}
