package Model;

/**
 * Created by Andreas on 17-03-2017.
 */
public class ActivityInteracter
{
    public String save(Activity activity)
    {
        String sqlStatement;

        sqlStatement = "INSERT INTO activity VALUES " + activity.getID() + ", '" +
        activity.getActivityName() + "', " + activity.getAgeLimit() + ", " + activity.getHeightLimit();

        return sqlStatement;
    }

    public String editID(Activity activity)
    {
        int a = 2;

        String sqlStatement = "INSERT INTO activity (act_id) VALUES " + a + " WHERE activity.act_id = " + activity.getID();

        return sqlStatement;
    }

    public String editName(Activity activity)
    {
        String newName = "Helicopter Driving";

        String sqlStatement = "INSERT INTO activity (act_name) VALUES '" + newName + "' WHERE activity.act_id = " + activity.getID();

        return sqlStatement;
    }
}
