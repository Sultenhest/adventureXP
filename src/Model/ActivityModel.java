package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
                    "VALUES ('"+ activity.getActivityName() +"', " + activity.getAgeLimit() + ", "
                    + activity.getHeightLimit() + ")";

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

            act = new Activity(rs.getInt(1), rs.getInt(3),
                    rs.getInt(4), rs.getString(2));

            st.close();
            conn.close();

            return act;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return new Activity(-1, -1, -1, "Error during Database Read");
        }
    }

    public ArrayList<Activity> readAll()
    {
        try
        {
            String sqlStatement = "SELECT * FROM activity";

            Connection conn = DatabaseConnect.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sqlStatement);

            ArrayList<Activity> listOfActivities = new ArrayList<>();

            while(rs.next())
            {
                listOfActivities.add(new Activity(rs.getInt(1), rs.getInt(3), rs.getInt(4), rs.getString(2)));
            }

            st.close();
            conn.close();

            return listOfActivities;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean update(Activity activity)
    {
        try {
            String sql = "UPDATE activity SET act_name = '" + activity.getActivityName() +
                    "', act_min_age = " + activity.getAgeLimit() +
                    ", act_min_height = " + activity.getHeightLimit() +
                    " WHERE act_id = " + activity.getID();

            Connection conn = DatabaseConnect.getConnection();
            Statement st = conn.createStatement();
            int rowsAffected = st.executeUpdate(sql);

            return (rowsAffected == 1);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id)
    {
        try {
            String sql = "DELETE FROM activity WHERE act_id = " + id;

            Connection conn = DatabaseConnect.getConnection();
            Statement st = conn.createStatement();
            int rowsAffected = st.executeUpdate(sql);

            return (rowsAffected == 1);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }
}
