package Model;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

//
//Created by DaMasterHam on 21-03-2017.
//
public class DatabaseConnectTest 
{
    @Test
    public void SetDataConnectionValues() throws Exception
    {
        DatabaseConnect.setDbName("adventure_xp");
        DatabaseConnect.setUser("root");
        DatabaseConnect.setPass("pass1234");
        DatabaseConnect.setPort("4200");


        Connection conn = DatabaseConnect.getConnection();

        assertNotNull(conn);

    }

    @Test
    public void SaveActivity() throws Exception
    {
        DatabaseConnect.setDbName("adventure_xp");
        DatabaseConnect.setUser("root");
        DatabaseConnect.setPass("pass1234");
        DatabaseConnect.setPort("4200");

        Activity act = new Activity("Sumo", 15, 150);
        boolean saveSuccesful = act.save();

        assertTrue(saveSuccesful);
    }
}