package Model;

public class Activity
{
    private int ID;
    private int ageLimit;
    private int heightLimit;
    private String activityName;
    private String activityInfo;

    public Activity()
    {
    }

    public Activity(String name, int ageLimit, int heightLimit)
    {
        ID = -1;
        activityName = name;
        this.ageLimit = ageLimit;
        this.heightLimit = heightLimit;
    }

    public Activity(int ID, int ageLimit, int heightLimit, String activityName)
    {
        this.ID = ID;
        this.ageLimit = ageLimit;
        this.activityName = activityName;
        this.heightLimit = heightLimit;
    }

    public int getID()
    {
        return ID;
    }

//    public void setID(int ID)
//    {
//        this.ID = ID;
//    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (getID() != activity.getID()) return false;
        if (getAgeLimit() != activity.getAgeLimit()) return false;
        if (getHeightLimit() != activity.getHeightLimit()) return false;
        if (getActivityName() != null ? !getActivityName().equals(activity.getActivityName()) : activity.getActivityName() != null)
            return false;
        return getActivityInfo() != null ? getActivityInfo().equals(activity.getActivityInfo()) : activity.getActivityInfo() == null;
    }

    @Override
    public int hashCode() {
        int result = getID();
        result = 31 * result + getAgeLimit();
        result = 31 * result + getHeightLimit();
        result = 31 * result + (getActivityName() != null ? getActivityName().hashCode() : 0);
        result = 31 * result + (getActivityInfo() != null ? getActivityInfo().hashCode() : 0);
        return result;
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
