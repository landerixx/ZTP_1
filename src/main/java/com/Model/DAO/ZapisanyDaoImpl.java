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



    public void deleteAllZapisany(int ID, boolean whichOne) {

    }
}
