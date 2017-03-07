package com.Model.DAO;

import com.Model.DataSource;
import com.Model.Entity.Kurs;
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
public class KursDaoImpl implements KursDao {

    public List<Kurs> getAllCourses() {

        Connection con =null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Kurs> kursList = new ArrayList<Kurs>();
        String query = "SELECT * FROM kurs";

        try {
            DataSource dataSource = new DataSource();
            con = dataSource.createConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while(rs.next()){

                Kurs kurs = new Kurs();
                kurs.setKursId(rs.getInt("kursid"));
                kurs.setKursName(rs.getString("kursname"));
                kursList.add(kurs);
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

        return kursList;
    }//public List<Kurs> getAllCourses()



    public void addKurs(Kurs kurs) {

        Connection dbConnection = null;
        Statement statement = null;
        String sql = "insert into kurs values(" + kurs.getKursId() + "," + "'" + kurs.getKursName() + "'"   + ")";

        try {
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.executeUpdate(sql);

            System.out.println("Record is inserted into kurs table for  Kurs : " + kurs.getKursName());
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

    } // public void addKurs(Kurs kurs)

    public Kurs getKurs(int kursId) {


        DataSource dataSource = new DataSource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM kurs where kursid="+kursId;

        try{

            con = dataSource.createConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while( rs.next() ) {

                Kurs kurs = new Kurs();
                kurs.setKursId(rs.getInt("kursid"));
                kurs.setKursName(rs.getString("kursname"));
                return kurs;
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
    }//public Kurs getKurs(int KursId)




    public void updateKurs(Kurs kurs) {

        Connection dbConnection = null;
        Statement statement = null;

        String sql = "update kurs set kursname=" + "'" + kurs.getKursName() + "'" + "where kursid="
                + kurs.getKursId();

        try {

            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.executeUpdate(sql);

            System.out.println("Record is updated into Kurs table for Kurs id : "
                    + kurs.getKursId());

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
    } //  public void updateKurs(Kurs kurs)



    public void deleteKurs(int kursId) {

        Connection dbConnection = null;
        Statement statement = null;

        String sql = "delete from kurs where kursid="+ kursId;

        try{
            DataSource dataSource = new DataSource();
            dbConnection = dataSource.createConnection();
            statement = dbConnection.prepareStatement(sql);
            statement.executeUpdate(sql);

            System.out.println("Record is deleted from Kurs table for Kurs id : "
                    + kursId);
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

    }// public void deleteKurs(int KursId)
}
