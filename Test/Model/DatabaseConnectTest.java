package Model;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

//
//Created by DaMasterHam on 28-03-2017.
//
public class DatabaseConnectTest
{

    private void setupDB()
    {
        // Change the credentials to your local db's credentials to test locally
        DatabaseConnect.setDbName("adventure_xp");
        DatabaseConnect.setUser("root");
        DatabaseConnect.setPass("pass1234");
        DatabaseConnect.setPort("4200");
    }


    @Test
    public void GetDatabaseConnection() throws Exception
    {
        setupDB();

        Connection conn = DatabaseConnect.getConnection();

        assertFalse(conn.isClosed());
    }

}