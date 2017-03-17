package Model;

import java.util.Scanner;

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

    public String edit(Activity activity)
    {
        int a = activity.getID();

        String sqlStatement = "INSERT INTO activity (act_id) VALUES 1 WHERE activity.act_id = " + a;

        return sqlStatement;
    }
}
