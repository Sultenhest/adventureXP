package Model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

//
//Created by DaMasterHam on 23-03-2017.
//
public class ActivityModelTest 
{
    @Test
    public void DeleteItem() throws Exception
    {
        DatabaseConnect.setDbName("adventure_xp");
        DatabaseConnect.setUser("root");
        DatabaseConnect.setPass("pass1234");
        DatabaseConnect.setPort("4200");

        //ActivityModel.getInstance().insert(new Activity("Test", 12, 123));

        boolean delete = ActivityModel.getInstance().delete(15);

        assertTrue(delete);
    }
}