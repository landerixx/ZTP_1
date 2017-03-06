package com.Model;

/**
 * Created by Piotrek on 2017-03-06.
 */
import java.sql.Connection;
import org.apache.commons.dbcp.BasicDataSource;

public class DataSource {
    Connection      connection = null;
    BasicDataSource bdSource   = new BasicDataSource();

    public DataSource()
    {
        bdSource.setDriverClassName("com.mysql.jdbc.Driver");
        bdSource.setUrl("jdbc:mysql://localhost:3306/ztp_1");
        bdSource.setUsername("root");
        bdSource.setPassword("root");
    }

    public Connection createConnection()
    {
        Connection con = null;
        try
        {
            if( connection != null )
            {
                System.out.println("Cant create a New Connection");
            }
            else
            {
                con = bdSource.getConnection();
                System.out.println("Connected to DB");
            }
        }
        catch( Exception e )
        {
            System.out.println("Error Occured " + e.toString());
        }
        return con;
    }
}