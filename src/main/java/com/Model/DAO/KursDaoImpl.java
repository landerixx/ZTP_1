package com.Model.DAO;

import com.Model.ConnectionSingleton;
import com.Model.DbUtil;
import com.Model.Entity.Kurs;

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

    private Connection connection;
    private Statement statement;
    private ResultSet rs = null;


    public List<Kurs> getAllCourses() {


        List<Kurs> kursList = new ArrayList<Kurs>();
        String query = "SELECT * FROM kurs";

        try {
            connection = ConnectionSingleton.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

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
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }

        return kursList;
    }//public List<Kurs> getAllCourses()



    public void addKurs(Kurs kurs) {


        String sql = "insert into kurs values(" + kurs.getKursId() + "," + "'" + kurs.getKursName() + "'"   + ")";

        try {
            connection = ConnectionSingleton.getConnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);

            System.out.println("Record is inserted into kurs table for  Kurs : " + kurs.getKursName());
        }
        catch( SQLException e ) {
            e.printStackTrace();
        }
        finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }

    } // public void addKurs(Kurs kurs)

    public Kurs getKurs(int kursId) {



        String query = "SELECT * FROM kurs where kursid="+kursId;

        try{

            connection = ConnectionSingleton.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

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
            DbUtil.close(rs);
            DbUtil.close(statement);
            DbUtil.close(connection);
        }
        return null;
    }//public Kurs getKurs(int KursId)




    public void updateKurs(Kurs kurs) {



        String sql = "update kurs set kursname=" + "'" + kurs.getKursName() + "'" + "where kursid="
                + kurs.getKursId();

        try {

            connection = ConnectionSingleton.getConnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);

            System.out.println("Record is updated into Kurs table for Kurs id : "
                    + kurs.getKursId());

        }
        catch( SQLException e ) {
            e.printStackTrace();
        }
        finally {
            DbUtil.close(statement);
            DbUtil.close(connection);

        }
    } //  public void updateKurs(Kurs kurs)



    public void deleteKurs(int kursId) {


        String sql = "delete from kurs where kursid="+ kursId;

        try{
            connection = ConnectionSingleton.getConnection();
            statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);

            System.out.println("Record is deleted from Kurs table for Kurs id : "
                    + kursId);
        }
        catch( SQLException e ) {
            e.printStackTrace();
        }
        finally {
            DbUtil.close(statement);
            DbUtil.close(connection);
        }

    }// public void deleteKurs(int KursId)
}
