package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Christian and Sose on 16-03-2017.
 */

public class Activity
{
    private int ID;
    private int ageLimit;
    private int heightLimit;
    private String activityName;
    private String activityInfo;

    public Activity(String name, int ageLimit, int heightLimit)
    {
        activityName = name;
        this.ageLimit = ageLimit;
        this.heightLimit = heightLimit;
    }

    public Activity(int ID, int ageLimit, String activityName, String activityInfo)
    {
        this.ID = ID;
        this.ageLimit = ageLimit;
        this.activityName = activityName;
        this.activityInfo = activityInfo;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public int getAgeLimit()
    {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit)
    {
        this.ageLimit = ageLimit;
    }

    public int getHeightLimit()
    {
        return heightLimit;
    }

    public void setHeightLimit(int heightLimit)
    {
        this.heightLimit = heightLimit;
    }

    public String getActivityName()
    {
        return activityName;
    }

    public void setActivityName(String activityName)
    {
        this.activityName = activityName;
    }

    public String getActivityInfo()
    {
        return activityInfo;
    }

    public void setActivityInfo(String activityInfo)
    {
        this.activityInfo = activityInfo;
    }


//    public boolean save()
//    {
//        try
//        {
//            String sqlStatement = "INSERT INTO activity (act_name, act_min_age, act_min_height) "  +
//                    "VALUES ('"+ activityName +"', " + ageLimit + ", " + heightLimit + ")";
//
//            Connection conn = DatabaseConnect.getConnection();
//            Statement st = conn.createStatement();
//            int rowsAffected = st.executeUpdate(sqlStatement);
//
//            st.close();
//            conn.close();
//
//            return (rowsAffected == 1);
//        }
//        catch (Exception ex)
//        {
//            ex.printStackTrace();
//            return false;
//        }
//    }

}
