package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Andreas on 17-03-2017.
 */
public class ActivityModel
{
    private static ActivityModel instance = null;

    private ActivityModel() {}

    public static ActivityModel getInstance()
    {
        if (instance == null)
            instance = new ActivityModel();

        return instance;
    }


    public boolean insert(Activity activity)
    {
        try
        {
            String sqlStatement = "INSERT INTO activity (act_name, act_min_age, act_min_height) "  +
                    "VALUES ('"+ activity.getActivityName() +"', " + activity.getAgeLimit() + ", " + activity.getHeightLimit() + ")";

            Connection conn = DatabaseConnect.getConnection();
            Statement st = conn.createStatement();
            int rowsAffected = st.executeUpdate(sqlStatement);

            st.close();
            conn.close();

            return (rowsAffected == 1);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    public Activity read(int id)
    {
        try
        {
            String sqlStatement = "SELECT * FROM activity WHERE act_id = " + id;

            Connection conn = DatabaseConnect.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sqlStatement);

            Activity act;

            act = new Activity(rs.getInt(1), rs.getInt(3), rs.getString(2), "");

            st.close();
            conn.close();

            return act;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return new Activity(-1, -1, "", "");
        }
    }

    public boolean update(Activity activity)
    {

        return false;
    }

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

        String sqlStatement = "INSERT INTO activity (act_id) VALUES " + a + " WHERE activity.act_id = " + activity.getID();

        return sqlStatement;
    }

    public String editName(Activity activity)
    {
        String newName = "Helicopter Driving";

        String sqlStatement = "INSERT INTO activity (act_name) VALUES '" + newName + "' WHERE activity.act_id = " + activity.getID();

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
        String desc = "Whacha fuckin' think this be aboot?";

        String sql = "UPDATE activity SET act_description = " + desc + " WHERE act_id = " + activity.getID();

        return sql;
    }
}
