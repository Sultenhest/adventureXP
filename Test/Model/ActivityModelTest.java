package Model;

import org.junit.Assert;
import org.junit.Test;
import org.omg.PortableInterceptor.ACTIVE;

import static org.junit.Assert.*;

//
//Created by DaMasterHam on 23-03-2017.
//
public class ActivityModelTest 
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
    public void ActivityCRUD() throws Exception
    {
        setupDB();

        boolean success = InsertActivity() && UpdateActivity() && DeleteActivity();

        assertTrue(success);

    }

    public boolean InsertActivity() throws Exception
    {
        return ActivityModel.getInstance().insert(new Activity(99, 12, 123,"Activity_Test"));
    }

    public boolean UpdateActivity () throws Exception
    {
         return ActivityModel.getInstance().update(new Activity(99, 13,133, "Activity_Test_Updated"));
    }

    public boolean DeleteActivity() throws Exception
    {
        return ActivityModel.getInstance().delete(99);
    }
}