package com.Model.DAO;

import com.Model.ConnectionSingleton;
import com.Model.DbUtil;
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

    private Connection connection;
    private Statement statement;
    private ResultSet rs = null;

    public List<Zapisany> getAllZapisany() {


        List<Zapisany> zapisanyList = new ArrayList<Zapisany>();
        String query = "SELECT * FROM zapisany";

        try {
            connection = ConnectionSingleton.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

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
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }

        return zapisanyList;

    }// public List<Zapisany> getAllZapisany()



    public void addZapisany(Zapisany zapisany) {


        String sql = "insert into zapisany values(" + zapisany.getKursId() + "," + "'" + zapisany.getStudentId() + "'"   + ")";

        try {
            connection = ConnectionSingleton.getConnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);

            System.out.println("Record is inserted into zapisany table for  Zapisany : (" + zapisany.getKursId() + "," + zapisany.getStudentId() +")");
        }
        catch( SQLException e ) {
            e.printStackTrace();
        }
        finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }

    }// public void addZapisany(Zapisany zapisany)


    public Zapisany getZapisany(int kursId, int studentId) {


        String query = "SELECT * FROM zapisany where kursid="+kursId +" AND studentid="+studentId;

        try{

            connection = ConnectionSingleton.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
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
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return null;

    }// public Zapisany getZapisany(int kursId, int studentId)

    public void updateZapisany(Zapisany zapisany) {

    }



    public void deleteZapisany(int kursId, int studentId) {




        String sql = "delete from zapisany where kursid="+kursId +" AND studentid="+ studentId;

        try{
            connection = ConnectionSingleton.getConnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);

            System.out.println("Record is deleted from ZAPISANY table for (kursId,StudentId): ("
                    +kursId +"," +studentId+")");
        }
        catch( SQLException e ) {
            e.printStackTrace();
        }
        finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }

    }//public void deleteZapisany(int kursId, int studentId)


    /**
     *
     * WHEN whichOne is TRUE
     *  THEN ID=studentID, usuwamy wszystkie KURSY na ktore zapisal sie STUDENT
     *
     *  WHEN whichOne is FALSE
     *  THEN ID=kursID, usuwamy wszystkich STUDENTOW zapisanych na ten KURS
     *
     *
     * @param ID: Student or kurs id
     * @param whichOne: BOOLEAN, if equals  TRUE: ID=studentID, kursId otherwise
     *
     *
     */


    public void deleteAllZapisany(int ID, boolean whichOne) {

        String sql;

        if(whichOne)
            sql  = "delete from zapisany where studentid="+ ID;
        else
            sql = "delete from zapisany where kursid="+ ID;

        try{
            connection = ConnectionSingleton.getConnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);

            System.out.print("Records are deleted from ZAPISANY table for  ");
            if(whichOne)
                System.out.println("WSZYSTKIE ZAPISANIA Z student ID: " + ID +" ZATEM USUNIETE WSZYSTKIE KURSY TEGO STUDENTA");
            else
                System.out.println("WSZYSTKIE ZAPISANIA Z kurs ID: " + ID + " ZATEM USUNIECI WSZYSCY STUDENCI Z TEGO KURSU");
        }
        catch( SQLException e ) {
            e.printStackTrace();
        }
        finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }

    }//public void deleteAllZapisany(int ID, boolean whichOne)
}
