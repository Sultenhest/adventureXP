package Model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andreas on 17-03-2017.
 */
public class ActivityInteracterTest
{
    @Test
    public void createActivityTest() throws Exception
    {
        Activity activity = new Activity(1, 18, "Helicopter Flying", "The name LITERALLY says it all: You fly a fucking helicopter!");

        assertFalse(activity == null);
    }

    @Test
    public void saveTest() throws Exception
    {
        ActivityInteracter AI = new ActivityInteracter();
        Activity activity = new Activity(1, 18, "Helicopter Flying", "The name LITERALLY says it all: You fly a fucking helicopter!");

        assertEquals("INSERT INTO activity VALUES 1, 'Helicopter Flying', 18, 0", AI.save(activity));
    }

    @Test
    public void editTest() throws Exception
    {
        ActivityInteracter AI = new ActivityInteracter();
        Activity activity = new Activity(1, 18, "Helicopter Flying", "The name LITERALLY says it all: You fly a fucking helicopter!");

        assertEquals("INSERT INTO activity (act_id) VALUES 1 WHERE activity.act_id = " + activity.getID(), AI.edit(activity));
    }
}