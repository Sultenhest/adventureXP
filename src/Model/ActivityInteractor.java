package Model;

/**
 * Created by Andreas on 17-03-2017.
 */
public class ActivityInteractor
{
    public String save(Activity activity)
    {
        String sqlStatement;

        sqlStatement = "UPDATE activity SET " + activity.getID() + ", '" +
        activity.getActivityName() + "', " + activity.getAgeLimit() + ", " + activity.getHeightLimit();

        return sqlStatement;
    }

    public String editID(Activity activity)
    {
        int a = 2;

        String sqlStatement = "UPDATE activity SET act_id = " + a + " WHERE activity.act_id = " + activity.getID();

        return sqlStatement;
    }

    public String editName(Activity activity)
    {
        String newName = "Helicopter Driving";

        String sqlStatement = "UPDATE activity SET act_name = " + newName + " WHERE activity.act_id = " + activity.getID();

        return sqlStatement;
    }

    public String editAge(Activity activity)
    {
        int a = 7;

        String sql = "UPDATE activity SET act_min_age = " + a + " WHERE act_id = " + activity.getID();

        return sql;
    }

    public String editDescription(Activity activity)
    {
        return "";
    }
}
