package Model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andreas on 17-03-2017.
 */
public class ActivityInteractorTest {
    @Test
    public void createActivityTest() throws Exception {
        Activity activity = new Activity(1, 18, "Helicopter Flying", "The name LITERALLY says it all: You fly a fucking helicopter!");

        assertFalse(activity == null);
    }

    @Test
    public void saveTestCorrectSQLStatement() throws Exception {
        ActivityInteractor AI = new ActivityInteractor();
        Activity activity = new Activity(1, 18, "Helicopter Flying", "The name LITERALLY says it all: You fly a fucking helicopter!");

        assertEquals("INSERT INTO activity VALUES 1, 'Helicopter Flying', 18, 0", AI.save(activity));

        /*DatabaseConnect.getStatement().executeQuery(AI.save(activity));

        saveTestCorrectDatabaseRead(activity, AI);
    }

    @Test
    public void saveTestCorrectDatabaseRead(Activity activity, ActivityInteractor AI) throws Exception
    {
        assertEquals("1, Helicopter Flying, 18, 0",
                "" + DatabaseConnect.getStatement().executeQuery("SELECT * FROM activity WHERE activity.act_id = " + activity.getID()));
    */
    }

    @Test
    public void editIDTestCorrectSQLStatement() throws Exception {
        ActivityInteractor AI = new ActivityInteractor();
        Activity activity = new Activity(1, 18, "Helicopter Flying", "The name LITERALLY says it all: You fly a fucking helicopter!");

        assertEquals("INSERT INTO activity (act_id) VALUES 2 WHERE activity.act_id = " + activity.getID(), AI.editID(activity));

        /*DatabaseConnect.getStatement().executeQuery(AI.editID(activity));

        editIDTestCorrectDatabaseRead(activity, AI);
    }

    @Test
    public void editIDTestCorrectDatabaseRead(Activity activity, ActivityInteractor AI) throws Exception
    {
        assertEquals("2, Helicopter Flying, 18, 0",
                "" + DatabaseConnect.getStatement().executeQuery("SELECT * FROM activity WHERE activity.act_id = " + activity.getID()));
    */
    }

    @Test
    public void editNameTestCorrectSQLStatement() throws Exception {
        ActivityInteractor AI = new ActivityInteractor();
        Activity activity = new Activity(1, 18, "Helicopter Flying", "The name LITERALLY says it all: You fly a fucking helicopter!");

        assertEquals("INSERT INTO activity (act_name) VALUES 'Helicopter Driving' WHERE activity.act_id = " + activity.getID(), AI.editName(activity));

        /*DatabaseConnect.getStatement().executeQuery(AI.editName(activity));

        editNameTestCorrectDatabaseRead(activity, AI);
    }

    @Test
    public void editNameTestCorrectDatabaseRead(Activity activity, ActivityInteractor AI) throws Exception
    {
        assertEquals("2, Helicopter Driving, 18, 0",
                "" + DatabaseConnect.getStatement().executeQuery("SELECT * FROM activity WHERE activity.act_id = " + activity.getID()));
    */
    }

    @Test
    public void editAgeTestCorrectSQLStatement() throws Exception {

        ActivityInteractor AI = new ActivityInteractor();
        Activity activity = new Activity(1, 18, "Helicopter Flying", "The name LITERALLY says it all: You fly a fucking helicopter!");

        assertEquals("UPDATE activity SET act_min_age = 7 WHERE act_id = 1", AI.editAge(activity));

        /*DatabaseConnect.getStatement().executeQuery(AI.editAge(activity));

        editAgeTestCorrectDatabaseRead(activity, AI);
    }

    @Test
    public void editAgeTestCorrectDatabaseRead() throws Exception
    {
        assertEquals("1, Helicopter Driving, 7, 0", "" + DatabaseConnect.getStatement().executeQuery("SELECT * FROM activity WHERE activity.act_id = " + activity.getID()));
    */
    }
}
